package com.example.redis.dao;

import com.example.redis.RedisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

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
    public void findUserByName() {
        System.out.println(userDao.findUserByName("Cooper"));
    }
}