package com.it.alibaba.service.impl;

import com.it.alibaba.entity.Stock;
import com.it.alibaba.mapper.StockMapper;
import com.it.alibaba.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存表 服务实现类
 * </p>
 *
 * @author JiangKangWei
 * @since 2022-09-02
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {


    public Stock getStcok(Long id){
        return baseMapper.selectById(id);
    }
}
