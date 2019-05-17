package com.example.mybatis.MybatisCache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangqianlong
 * @create 2019-05-17 18:00
 */

public class MybatisRedisCache implements Cache {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final String id;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static JedisConnectionFactory jedisConnectionFactory;

    /**
     * 这个地方需要静态注入，这里通过中间类 MybatisRedisCacheTransfer 实现的
     * @param jedisConnectionFactory
     */
    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }


    public MybatisRedisCache(final String id) {
        if (null == id || "".equals(id)) {
            throw new IllegalArgumentException("mybatis redis cache need an id.");
        }
        this.id = id;
        LOGGER.debug("mybatis redis cache id: {}", id);
    }


    @Override
    public String getId() {
        return this.id;
    }

    /**
     * 存值
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        if (null == key) {
            return;
        }
        LOGGER.debug("mybatis redis cache put. K={} value={}", key, value);
        RedisConnection redisConnection = null;
        try {
            redisConnection = jedisConnectionFactory.getConnection();
            RedisSerializer serializer = new JdkSerializationRedisSerializer();
            redisConnection.set(serializer.serialize(key), serializer.serialize(value));

            // 将key保存到redis.list中
            redisConnection.lPush(serializer.serialize(id), serializer.serialize(key));
            System.out.println("id是的是的是的"+id);
        } catch (Exception e) {
            LOGGER.error("mybatis redis cache put exception. K=" + key + " V=" + value + "", e);
        } finally {
            if (null != redisConnection) {
                redisConnection.close();
            }
        }
    }

    /**
     * 取值
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        if (null == key) {
            return null;
        }
        LOGGER.debug("mybatis redis cache get. K={}", key);
        RedisConnection redisConnection = null;
        Object result = null;
        try {
            redisConnection = jedisConnectionFactory.getConnection();
            RedisSerializer serializer = new JdkSerializationRedisSerializer();
            result = serializer.deserialize(redisConnection.get(serializer.serialize(key)));
        } catch (Exception e) {
            LOGGER.error("mybatis redis cache get exception. K=" + key + " V=" + result + "", e);
        } finally {
            if (null != redisConnection) {
                redisConnection.close();
            }
        }
        return result;
    }

    /**
     * 删值
     * @param key
     * @return
     */
    @Override
    public Object removeObject(Object key) {
        if (null == key) {
            return null;
        }
        LOGGER.debug("mybatis redis cache remove. K={}", key);
        RedisConnection redisConnection = null;
        Object result = null;
        try {
            redisConnection = jedisConnectionFactory.getConnection();
            RedisSerializer serializer = new JdkSerializationRedisSerializer();
            // 讲key设置为立即过期
            result = redisConnection.expireAt(serializer.serialize(key), 0);

            // 将key从redis.list中删除
            redisConnection.lRem(serializer.serialize(id), 0, serializer.serialize(key));
        } catch (Exception e) {
            LOGGER.error("mybatis redis cache remove exception. " + key + " V=" + result + "", e);
        } finally {
            if (null != redisConnection) {
                redisConnection.close();
            }
        }
        return result;
    }

    /**
     * 清空缓存
     * flushCache="true" 的时候会调用这个地方
     */
    @Override
    public  void clear() {
        LOGGER.debug("mybatis redis cache clear. ");
        RedisConnection redisConnection = null;
        try {
            redisConnection = jedisConnectionFactory.getConnection();

            RedisSerializer serializer = new JdkSerializationRedisSerializer();

            /**
             * 千万不要直接 redisConnection.flushDb()，会把整个redis的东西都清除掉，我不相信你的redis里没有其他东西
             * 获取redis.list中的保存的key值，遍历删除
             */
            Long length = redisConnection.lLen(serializer.serialize(id));
            if (0 == length) {
                return;
            }
            List<byte[]> keyList = redisConnection.lRange(serializer.serialize(id), 0, length - 1);
            for (byte[] key : keyList) {
                redisConnection.expireAt(key, 0);
            }
            redisConnection.expireAt(serializer.serialize(id), 0);
            keyList.clear();
        } catch (Exception e) {
            LOGGER.error("mybatis redis cache clear exception. ", e);
        } finally {
            if (null != redisConnection) {
                redisConnection.close();
            }
        }
    }

    @Override
    public int getSize() {
        int result = 0;
        try {
            RedisConnection redisConnection = jedisConnectionFactory.getConnection();
            result = Math.toIntExact(redisConnection.dbSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

}
