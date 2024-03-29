package com.it.alibaba;

import com.alibaba.nacos.common.utils.ThreadUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
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
    Class<?>[] types = new Class[]{SpringApplication.class, String[].class};
    ConfigurableApplicationContext run = SpringApplication.run(OrderServer.class, args);
//    while(true){
//      System.out.println(run.getEnvironment().getProperty("user.name")+"=="
//          +run.getEnvironment().getProperty("user.age")+"=="
//          +run.getEnvironment().getProperty("user.sex")+"=="
//          +run.getEnvironment().getProperty("user.config"));
//      ThreadUtils.sleep(2000L);
//    }
  }
}
