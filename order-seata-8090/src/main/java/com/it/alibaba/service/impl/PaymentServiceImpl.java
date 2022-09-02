package com.it.alibaba.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.alibaba.entity.Payment;
import com.it.alibaba.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JiangKangWei
 * @since 2022-09-02
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IService<Payment> {


    public Payment getPayment(Long id){
        return baseMapper.selectById(id);
    }
}
