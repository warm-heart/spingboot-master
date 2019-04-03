package com.example.ajax.entity;

/**
 * @author wangqianlong
 * @create 2019-03-15 20:33
 */

public class User {
    private String userName;
    private String userAge;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public void da(){
        System.out.println("初始化");
    }

}
