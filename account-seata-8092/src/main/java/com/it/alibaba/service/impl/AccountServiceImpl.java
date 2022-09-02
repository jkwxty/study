package com.it.alibaba.service.impl;

import com.it.alibaba.entity.Account;
import com.it.alibaba.mapper.AccountMapper;
import com.it.alibaba.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author JiangKangWei
 * @since 2022-09-02
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {


    public Account getAccount(Long id){
        return baseMapper.selectById(id);
    }

}
