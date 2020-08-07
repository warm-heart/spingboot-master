package com.warm.heart.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangqianlong
 * @create 2020-08-02 17:36
 */

@ConfigurationProperties(prefix = RedisConfigProperties.REDIS_TIMEOUT_PREFIX)
public class RedisConfigProperties {

    public static final String REDIS_TIMEOUT_PREFIX = "redis.config";

    private Integer minRandomTimeout = 1;
    private Integer maxRandomTimeout = 10;

    private Integer maxIdle;

    private Integer maxTotal;

    private Integer maxWaitMillis;

    private Integer minEvictableIdleTimeMillis=1800000;

    private Integer numTestsPerEvictionRun;

    private long timeBetweenEvictionRunsMillis;

    private boolean testOnBorrow;

    private boolean testWhileIdle;

    public static String getRedisTimeoutPrefix() {
        return REDIS_TIMEOUT_PREFIX;
    }

    public Integer getMinRandomTimeout() {
        return minRandomTimeout;
    }

    public void setMinRandomTimeout(Integer minRandomTimeout) {
        this.minRandomTimeout = minRandomTimeout;
    }

    public Integer getMaxRandomTimeout() {
        return maxRandomTimeout;
    }

    public void setMaxRandomTimeout(Integer maxRandomTimeout) {
        this.maxRandomTimeout = maxRandomTimeout;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Integer maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public Integer getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public Integer getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }

    public void setNumTestsPerEvictionRun(Integer numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }
}
