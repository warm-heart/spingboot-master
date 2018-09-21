package com.example.shiro.entity;

import java.io.Serializable;

/**
 * @author wangqianlong
 * @create 2018-07-26 09:34
 */

public class User implements Serializable {
    private Long userId;
    private String userName;
    private String password;
    private String passwordSalt;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
}
