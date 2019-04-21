package com.example.ajax.entity;

/**
 * @author wangqianlong
 * @create 2019-03-15 20:33
 */

public class User {
    private String userName;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void da(){
        System.out.println("初始化");
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
