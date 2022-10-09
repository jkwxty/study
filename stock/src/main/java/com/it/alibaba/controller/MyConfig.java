package com.it.alibaba.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public User user(){
        User user = new User();
        user.setUserName("jkw");
        user.setAge("26");
        return user;
    }
}
