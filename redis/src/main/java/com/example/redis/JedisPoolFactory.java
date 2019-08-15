package com.example.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author wangqianlong
 * @create 2019-08-15 8:45
 */
@Configuration
public class JedisPoolFactory {


    @Bean
    public JedisPool jedisPool() {
        // jedis连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(1000);
        poolConfig.setMaxTotal(500);
        poolConfig.setMaxWaitMillis(500 * 1000);

        JedisPool  pool = new JedisPool (poolConfig, "127.0.0.1", 6379, 100);
        return pool;
    }
}
