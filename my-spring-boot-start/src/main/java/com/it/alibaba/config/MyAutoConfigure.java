package com.it.alibaba.config;

import com.it.alibaba.properties.MyProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JiangKangWei
 * @create 2022/9/6 21:17
 */
@Configuration
@EnableConfigurationProperties(MyProperties.class)
public class MyAutoConfigure {





}
