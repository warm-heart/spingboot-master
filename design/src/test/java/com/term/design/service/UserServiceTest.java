package com.term.design.service;

import com.term.design.DesignApplicationTests;
import com.term.design.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends DesignApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void findUserByPhone() {
        User user = userService.findUserByPhone("12345678910");
        //System.out.println("成功");
        System.out.println(user);
    }

    @Test
    public void insert() {
    }

    @Test
    public void findUserByName() {
        User user = userService.findUserByName("Cooper");
        //System.out.println("成功");
        System.out.println(user);
    }
}