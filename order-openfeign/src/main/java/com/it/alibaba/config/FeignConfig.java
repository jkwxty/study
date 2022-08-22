package com.it.alibaba.config;

import com.it.alibaba.customer.MyCustomerFeignInterceptor;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/19 17:29
 */


@Configuration
public class FeignConfig {

  /**
   * 设置日志优先级，还需要再配置文件中修改spring boot 默认的日志有限级别为
   * @return
   */
  @Bean
  public Logger.Level feignLoggerLevel(){
    return Logger.Level.FULL;
  }

  @Bean
  public Request.Options options(){
    //1 连接超时时间，2 请求处理超时时间
    return new Request.Options(5000,10000);
  }

  @Bean
  public MyCustomerFeignInterceptor requestInterceptor(){
    //自定义的feign拦截器
    return new MyCustomerFeignInterceptor();
  }
}
