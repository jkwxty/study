package com.it.alibaba.my;

import com.it.alibaba.properties.MyProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author JiangKangWei
 * @create 2022/9/7 11:59
 */
@Service
public class MyService {

    @Resource
    private MyProperties myProperties;

    public void print(){
        System.out.println(myProperties.getUserName()+"==="+myProperties.getPassword());
    }

}
