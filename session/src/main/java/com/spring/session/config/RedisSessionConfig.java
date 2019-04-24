package com.spring.session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author wangqianlong
 * @create 2019-03-21 21:55
 */
@Configuration
//session过期时间为60s 默认为30min
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
public class RedisSessionConfig {
}
