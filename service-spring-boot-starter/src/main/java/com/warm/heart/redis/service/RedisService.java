package com.warm.heart.redis.service;

import com.warm.heart.redis.config.RedisConfigProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author wangqianlong
 * @create 2020-08-02 11:41
 */
public class RedisService implements InitializingBean, ApplicationContextAware {

    private RedisTemplate redisTemplate;
    private RedisConfigProperties redisConfigProperties;
    private ApplicationContext applicationContext;

    /**
     * string 类型 放入元素
     *
     * @param key
     * @param value
     */
    public void putForString(String key, Object value, Long timeout) {
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.MINUTES);
    }

    /**
     * set nx ex
     *
     * @param key
     * @param value
     */
    public void putForStringIfAbsent(String key, Object value, Long timeout) {
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());

        redisTemplate.opsForValue().setIfAbsent(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * list 左侧放入一个元素
     *
     * @param key
     * @param value
     * @return
     */
    public Long putForListLeftPush(String key, Object value, Long timeout) {
        Long res = redisTemplate.opsForList().leftPush(key, value);
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());

        redisTemplate.expire(key, expire, TimeUnit.MINUTES);
        return res;
    }

    /**
     * list 右侧放入一个元素
     *
     * @param key
     * @param value
     * @return
     */
    public Long putForListRightPush(String key, Object value, Long timeout) {
        Long res = redisTemplate.opsForList().rightPush(key, value);
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());

        redisTemplate.expire(key, expire, TimeUnit.MINUTES);
        return res;
    }

    /**
     * set 放入一个或多个元素
     *
     * @param key
     * @param
     * @return
     */
    public Long putForSet(String key, Long timeout, Object... values) {
        Long res = redisTemplate.opsForSet().add(key, values);
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());

        redisTemplate.expire(key, expire, TimeUnit.MINUTES);
        return res;
    }

    /**
     * zset 放入一个元素
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    public Boolean putForZSet(String key, Object value, double score, Long timeout) {
        Boolean res = redisTemplate.opsForZSet().add(key, value, score);
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());

        redisTemplate.expire(key, expire, TimeUnit.MINUTES);
        return res;
    }

    /**
     * hash 放入一个元素
     *
     * @param key
     * @param hashKey
     * @param value
     */
    public void putForHash(String key, String hashKey, Object value, Long timeout) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());

        redisTemplate.expire(key, expire, TimeUnit.MINUTES);
    }

    /**
     * Hash 放入 map
     *
     * @param key
     * @param map
     */
    public void putForHashAll(String key, Map<String, Object> map, long timeout) {
        redisTemplate.opsForHash().putAll(key, map);
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());

        redisTemplate.expire(key, expire, TimeUnit.MINUTES);
    }

    /**
     * 获取 value
     *
     * @param key
     * @return
     */
    public Object getForString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 右 出list
     *
     * @param key
     * @return
     */
    public Object rightPopForList(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     * 左 出list
     *
     * @param key
     * @return
     */
    public Object leftPopForList(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 随即删除一个元素
     *
     * @param key
     * @return
     */
    public Object popForSet(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * 随机删除 N个元素
     *
     * @param key
     * @param count
     * @return
     */
    public List<Object> popForSet(String key, Long count) {
        return redisTemplate.opsForSet().pop(key, count);
    }

    /**
     * 获取指定score的数据
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<Object> rangeByScoreForZSet(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 从下标处获取N 个 zset中指定score范围中的数据
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public Set<Object> rangeByScoreForZSet(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count);
    }

    /**
     * 获取hash 的指定HashKey的数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    public Object getForHash(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 获取 hash中所有数据
     *
     * @param key
     * @return
     */
    public Map<Object, Object> entriesForHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 判断hash 中是否包含hashkey
     *
     * @param key
     * @param hashKey
     * @return
     */
    public boolean hasKeyForHash(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    /**
     * 删除key
     *
     * @param key
     * @return
     */
    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 批量 删除 key
     *
     * @param keys
     * @return
     */
    public Long delete(Collection<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 设置key的过期时间 加随机事件，防止缓存雪崩
     *
     * @param key
     * @param timeout 分钟为单位
     * @return
     */
    public Boolean expire(String key, Long timeout) {
        Long expire = timeout + ThreadLocalRandom.current()
                .nextInt(redisConfigProperties.getMinRandomTimeout(), redisConfigProperties.getMaxRandomTimeout());
        return redisTemplate.expire(key, expire, TimeUnit.MINUTES);
    }

    public void afterPropertiesSet() throws Exception {
        this.redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
        this.redisConfigProperties = applicationContext.getBean(RedisConfigProperties.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
