package com.it.alibaba.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author JiangKangWei
 * @create 2022/9/7 11:43
 */
@ConfigurationProperties(prefix = "my")
public class MyProperties {

    private String userName="jkw";

    private String password="123";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
