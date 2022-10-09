package com.it.alibaba;

import com.it.alibaba.controller.MyConfig;
import com.it.alibaba.controller.StockController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/2 10:59
 */

@SpringBootApplication
public class StockServer {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    context.getBean("user");
    System.out.println(context);
//    SpringApplication.run(StockServer.class,args);
  }
}
