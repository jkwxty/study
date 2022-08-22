package com.it.alibaba.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/19 17:29
 */


@Configuration
public class FeignConfig {
  @Bean
  public Logger.Level feignLoggerLevel(){
    return Logger.Level.FULL;
  }
}
