package com.it.config;

import com.it.alibaba.customer.MyCustomerLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/18 17:16
 */

@Configuration
public class RibbonConfig {

  @Bean
  public IRule iRule(){
    return new MyCustomerLoadBalancerRule();
  }

}
