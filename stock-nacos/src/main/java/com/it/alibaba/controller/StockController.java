package com.it.alibaba.controller;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
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


  @RequestMapping("/add")
  public String add(){
    System.out.println("添加库存");
    return "8012";
  }


}
