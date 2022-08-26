package com.it.alibaba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/25 17:36
 */
@RestController("/sentinel")
public class SentinelController {

    public final static String resource="hello";

    @RequestMapping("hello")
    public String flowRule(){


        return "";
    }


    @PostConstruct
    public void initRule(){

    }
}
