package com.example.redis.dao;

import com.example.redis.RedisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;


public class UserDaoTest extends RedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private UserDao userDao;
    @Test
    public void findUserByPhone() {

    }

    @Test
    public void insert() {
        redisTemplate.opsForValue().set("aaa","111");

    }

    @Test
    @Cacheable(value = "dada")
    public void findUserByName() {
        System.out.println(userDao.findUserByName("1"));
    }
}