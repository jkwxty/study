package com.it.alibaba.customer;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
/**
 *自定义feign 拦截器， 调用feign接口之前，会先通过这里，做一些统一配置
 * 可以在本类直接申明配置类注入，为了方便管理，这里注释掉配置类注解，放在Feignconfig中做统一管理
 * @author JiangKangWei
 * @create 2022/8/22 14:59
 */
//@Configuration
public class MyCustomerFeignInterceptor implements RequestInterceptor {

  @Override
  public void apply(RequestTemplate requestTemplate) {
    requestTemplate.header("UserCode","91785");
    requestTemplate.header("TenantId","10001");
  }
}
