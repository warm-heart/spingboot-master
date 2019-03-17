package com.example.redis.service;

import com.example.redis.RedisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends RedisApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void findUserByPhone() {
        userService.findUserByPhone("1");
        System.out.println(userService.findUserByPhone("1"));
    }
}