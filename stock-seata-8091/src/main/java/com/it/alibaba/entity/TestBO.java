package com.it.alibaba.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TestBO {
    /**
     * 下次执行时间
     */
    private String nextTime;

    /**
     * 手机号，户号
     */
    private String mobile;

    /**
     * 缴费金额
     */
    private String amount;
}
