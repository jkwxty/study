package com.it.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/2 10:59
 */

@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.it.alibaba.mapper")
public class StockServer {

  public static void main(String[] args) {
    SpringApplication.run(StockServer.class,args);
  }
}
