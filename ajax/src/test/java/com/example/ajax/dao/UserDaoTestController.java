package com.example.ajax.dao;

import com.example.ajax.AjaxApplicationTests;
import com.example.ajax.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserDaoTestController extends AjaxApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void users() {
        System.out.println(userDao.users());

    }
}