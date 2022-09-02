package com.it.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JiangKangWei
 * @create 2022/7/29 16:20
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.it.alibaba.mapper")
public class OrderServer {

  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext run = SpringApplication.run(OrderServer.class, args);

  }
}
