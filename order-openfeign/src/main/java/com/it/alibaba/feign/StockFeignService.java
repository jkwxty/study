package com.it.alibaba.feign;

import com.it.alibaba.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/19 16:18
 */
@FeignClient(name = "stock-service",path = "/stock",configuration = FeignConfig.class)
public interface StockFeignService {

  @RequestMapping("add")
  public String add();

}
