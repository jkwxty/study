package com.it.alibaba;

import com.alibaba.nacos.common.utils.ThreadUtils;
import com.it.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JiangKangWei
 * @create 2022/7/29 16:20
 */
@SpringBootApplication
@RibbonClients(value =
    {
        @RibbonClient(name = "stock-service",configuration = RibbonConfig.class)
    }
)
public class OrderServer {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  public static void main(String[] args) {
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
