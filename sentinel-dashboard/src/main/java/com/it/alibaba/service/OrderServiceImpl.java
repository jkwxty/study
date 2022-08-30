package com.it.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/30 9:31
 */
@Service
public class OrderServiceImpl {

    @SentinelResource(value = "getOrder")
    public String getOrder(){
        return "订单！";
    }
}
