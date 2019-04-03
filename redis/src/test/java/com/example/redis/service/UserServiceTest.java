package com.example.redis.service;

import com.example.redis.RedisApplicationTests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;




public class UserServiceTest extends RedisApplicationTests {
    @Autowired

    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    @Test
    public void findUserByPhone() {
   //  redisTemplate.opsForValue().getOperations().expire("1",10,TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("aa","nihao");
        userService.findUserByName("d");

    }
}