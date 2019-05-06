package com.spring.session;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author wangqianlong
 * @create 2019-05-05 16:44
 */

public class test extends SessionApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        System.out.println(redisTemplate
                .opsForValue().get(
                        "spring:session:sessions:e96750b8-fa59-43ca-89c2-2259c7d273be"));

    }
}
