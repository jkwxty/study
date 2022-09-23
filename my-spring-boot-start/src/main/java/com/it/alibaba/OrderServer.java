package com.it.alibaba;

import com.alibaba.nacos.common.utils.ThreadUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JiangKangWei
 * @create 2022/7/29 16:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServer {

  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  public static void main(String[] args) {
    AnnotationConfigApplicationContext conte = new AnnotationConfigApplicationContext();
    ConfigurableApplicationContext run = SpringApplication.run(OrderServer.class, args);

  }
}
