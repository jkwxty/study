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
import com.alibaba.nacos.common.utils.ThreadUtils;
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


    @RequestMapping("hello2")
    public String hello2(){
        return flowRule2();
    }


    @RequestMapping("flowRule2")
    @SentinelResource(value = "flowRule2",blockHandler = "myBlockHandler")
    public String flowRule2(){
        ThreadUtils.sleep(3000);
        return "hello";
    }

    public String myBlockHandler(BlockException ex){
        return "当前请求人数过多，请稍后重试！";
    }

}
