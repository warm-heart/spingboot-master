package com.example.ajax.dao;

import com.example.ajax.AjaxApplicationTests;

import com.example.ajax.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDaoTestController extends AjaxApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void users() {
        System.out.println(userDao.users());

    }

    @Test
    public void update() {
        User user = userDao.getUserByUserId("2");
        System.out.println(user);

        System.out.println("Mybatis update 结果"+userDao.update(user));
    }

}