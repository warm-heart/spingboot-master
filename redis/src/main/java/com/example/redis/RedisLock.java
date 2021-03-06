package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @author wangqianlong
 * @create 2019-05-02 19:44
 */
@Component
public class RedisLock {
    Logger logger = LoggerFactory.getLogger(RedisLock.class);


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis 是单线程的的
     * * setnx  getset 两个命令
     * * 是redis分布式锁的原理
     * <p>
     * 加锁
     *
     * @param key   业务商品号等等
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }


        String currentValue = stringRedisTemplate.opsForValue().get(key);


        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //多线程情况下有可能会修改别人key的值
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);
            //再次判断别的线程有没有修改
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            logger.error("【redis分布式锁】解锁异常，{}", e);
        }
    }


}
