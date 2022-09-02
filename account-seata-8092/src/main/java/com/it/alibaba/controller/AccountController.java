package com.it.alibaba.controller;


import com.it.alibaba.entity.Account;
import com.it.alibaba.service.impl.AccountServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 账户表 前端控制器
 * </p>
 *
 * @author JiangKangWei
 * @since 2022-09-02
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountServiceImpl accountService;

    @RequestMapping("get")
    public Account get(Long id){
        return accountService.getAccount(id);
    }


    @RequestMapping("reduce")
    @GlobalTransactional
    public void reduce(Long id){
        System.out.println("1");
    }

}
