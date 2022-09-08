package com.it.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/2 10:59
 */

@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.it.alibaba.mapper")
public class AccountServer {

  public static void main(String[] args) {
    Class<?>[] types = new Class[]{SpringApplication.class, String[].class};
    SpringApplication.run(AccountServer.class,args);
  }
}
