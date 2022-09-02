package com.it.alibaba.controller;

import javax.annotation.Resource;

import com.it.alibaba.entity.Stock;
import com.it.alibaba.service.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/2 11:51
 */
@RestController
@RequestMapping("/stock")
public class StockController {

  @Resource
  private StockServiceImpl stockService;

  @RequestMapping("/add")
  public String add(){
    System.out.println("添加库存");
    return "8012";
  }

  @RequestMapping("/get")
  public Stock get(Long id){
    return stockService.getStcok(id);
  }


}
