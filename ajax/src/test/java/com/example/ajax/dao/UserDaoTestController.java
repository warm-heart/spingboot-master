package com.example.ajax.dao;

import com.example.ajax.AjaxApplicationTests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDaoTestController extends AjaxApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void users() {
        System.out.println(userDao.users());


    }
}