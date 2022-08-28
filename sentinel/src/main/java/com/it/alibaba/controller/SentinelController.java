package com.it.alibaba.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/25 17:36
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    public final static String resource="hello";

    /**
     * 手动exist方式进行流控
     * @return
     */
    @RequestMapping("hello")
    public String flowRule(){
        Entry entry=null;
        try {
            entry = SphU.entry(resource);
            return resource;
        } catch (BlockException e) {
            e.printStackTrace();
            return "被流控了！";
        } catch (Exception ex) {
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(ex, entry);
        } finally {
            // 务必保证 exit，务必保证每个 entry 与 exit 配对
            if (entry != null) {
                entry.exit();
            }
        }

        return "";
    }


    @RequestMapping("hello2")
    @SentinelResource(value = resource,blockHandler = "myBlockHandler")
    public String hello2(){
        return flowRule2();
    }



    public String flowRule2(){
        return "hello";
    }

    public String myBlockHandler(BlockException ex){
        return "当前请求人数过多，请稍后重试！";
    }


    /**
     * 初始化规则,服务启动的时候会初始化
     */
    @PostConstruct
    public void initRule(){
        ArrayList<FlowRule> rules = new ArrayList<>();
        FlowRule flowRule = new FlowRule(resource);
        //慢调用比例模式下为慢调用临界 RT（超出该值计为慢调用）；异常比例/异常数模式下为对应的阈值
        flowRule.setCount(1);
        //限流阈值类型，QPS 模式（1）或并发线程数模式（0）,默认QPS模式
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rules.add(flowRule);
        //
        FlowRuleManager.loadRules(rules);

    }
}
