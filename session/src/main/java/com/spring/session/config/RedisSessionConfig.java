package com.spring.session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author wangqianlong
 * @create 2019-03-21 21:55
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
