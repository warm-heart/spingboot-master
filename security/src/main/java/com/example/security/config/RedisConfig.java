package com.example.security.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

/**
 * @author wangqianlong
 * @create 2018-07-28 12:56
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * @description 自定义的缓存key的生成策略
     *              若想使用这个key  只需要讲注解上keyGenerator的值设置为keyGenerator即可</br>
     * @return 自定义策略生成的key
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for(Object obj:params){
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
    //缓存管理器
    @Bean
    public RedisCacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager=new RedisCacheManager(redisTemplate);
        /*设置缓存过期时间60s*/
        //redisCacheManager.setDefaultExpiration(60);
        return  redisCacheManager;
    }

    /**
     * RedisTemplate配置
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory ) {

        //设置序列化
        StringRedisTemplate template=new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om =new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
    }
