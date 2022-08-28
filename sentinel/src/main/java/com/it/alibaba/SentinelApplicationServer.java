package com.it.alibaba;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/25 17:25
 */
@SpringBootApplication
public class SentinelApplicationServer {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplicationServer.class,args);
    }

    @Bean
    public SentinelResourceAspect sentinelResourceAspect(){
        return new SentinelResourceAspect();
    }
}
