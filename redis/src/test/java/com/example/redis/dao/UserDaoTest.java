package com.example.redis.dao;

import com.example.redis.RedisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


public class UserDaoTest extends RedisApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    public void findUserByPhone() {

    }

    @Test
    public void insert() {
    }

    @Test
    @Cacheable(value = "dada")
    public void findUserByName() {
        System.out.println(userDao.findUserByName("1"));
    }
}