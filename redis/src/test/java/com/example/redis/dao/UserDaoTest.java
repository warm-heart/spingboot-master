package com.example.redis.dao;

import com.example.redis.RedisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


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
        redisTemplate.opsForValue().set("aaa", "111");
        redisTemplate.opsForValue().set("bbb","创建时设置过期时间设置十分钟",60*10,TimeUnit.SECONDS);
        //设置过期时间
        redisTemplate.expire("aaa", 100, TimeUnit.SECONDS);
        //操作list

        List<String> list = new ArrayList();
        list.add("hello");
        list.add("world");
        redisTemplate.opsForList().rightPush("nihao", list);

    }

    @Test
    @Cacheable(value = "dada")
    public void findUserByName() {
        System.out.println(userDao.findUserByName("1"));
    }
}