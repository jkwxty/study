package com.it.alibaba.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.it.alibaba.entity.Stock;
import com.it.alibaba.entity.TestBO;
import com.it.alibaba.mapper.StockMapper;
import com.it.alibaba.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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


    public static void main(String[] args)throws Exception {
        while(true){
            ArrayList<TestBO> testBOList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                TestBO testBO1 = new TestBO().setAmount(i+"00").setMobile(i+i+"").setNextTime(String.valueOf(System.currentTimeMillis()));
                testBOList.add(testBO1);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 5, 3000, TimeUnit.MILLISECONDS
                    , new LinkedBlockingQueue<>(5),(Runnable r, ThreadPoolExecutor executor)->{
                //拒绝策略
                System.out.println("进入拒绝策略："+Thread.currentThread());
            });
            List<TestBO> collect = testBOList.stream().map(item -> {
                return CompletableFuture.supplyAsync(() -> handle(item), threadPoolExecutor);
            }).map(CompletableFuture::join).collect(Collectors.toList());
            System.out.println(collect);

            CompletableFuture.allOf(testBOList.stream().map(item -> {
                return CompletableFuture.supplyAsync(() -> handle(item), threadPoolExecutor);
            }).toArray(CompletableFuture[]::new)).join();

            CompletableFuture[] array = testBOList.stream().map(item -> CompletableFuture.supplyAsync(() -> handle(item), threadPoolExecutor)
            ).toArray(CompletableFuture[]::new);
            CompletableFuture.allOf(array).join();



            threadPoolExecutor.shutdown();
        }

    }

    /**
     * 执行对应户号的自动缴费逻辑
     * @param testBO
     */
    public static  TestBO   handle(TestBO testBO){
        System.out.println("当前线程："+Thread.currentThread().getName());
        return testBO;
    }
}
