package com.it.alibaba.controller;

import com.it.alibaba.entity.Payment;
import com.it.alibaba.feign.StockFeignService;
import javax.annotation.Resource;

import com.it.alibaba.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/2 11:51
 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

  @Resource
  private RestTemplate restTemplate;
  @Resource
  private StockFeignService stockFeignService;
  @Resource
  private PaymentServiceImpl paymentService;

  @Value("${user.name}")
  private String name;
//  @RefreshScope("${user.age}")
//  private String age;


  @GetMapping("add")
  public String add(){
    String result = stockFeignService.add();
//    String result = restTemplate.getForObject("http://localhost:8012/stock/add", String.class);
//    System.out.println(result);
    return result;
  }
  @GetMapping("get")
  public Payment get(Long id){
    return paymentService.getPayment(id);

  }





}
