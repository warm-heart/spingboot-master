package com.example.redislettcue;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangqianlong
 * @create 2018-11-08 10:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private RedisTemplate redisTemplate;

    @org.junit.Test
    public void da() {
        redisTemplate.opsForValue().set("key", "Hello lettucue");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }
}
