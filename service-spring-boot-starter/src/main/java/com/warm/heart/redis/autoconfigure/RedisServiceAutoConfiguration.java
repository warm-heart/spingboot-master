package com.warm.heart.redis.autoconfigure;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warm.heart.redis.config.RedisConfigProperties;
import com.warm.heart.redis.service.RedisService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @author wangqianlong
 * @create 2020-08-02 17:02
 */
@Configuration
@AutoConfigureBefore(RedisAutoConfiguration.class)
@EnableConfigurationProperties(RedisConfigProperties.class)
public class RedisServiceAutoConfiguration implements InitializingBean, ApplicationContextAware {

    @Autowired
    RedisConfigProperties redisConfigProperties;

    /**
     * JedisPoolConfig 连接池
     *
     * @return
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大空闲数
        jedisPoolConfig.setMaxIdle(redisConfigProperties.getMaxIdle());
        // 连接池的最大数据库连接数
        jedisPoolConfig.setMaxTotal(redisConfigProperties.getMaxTotal());
        // 最大建立连接等待时间
        jedisPoolConfig.setMaxWaitMillis(redisConfigProperties.getMaxWaitMillis());
        // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        jedisPoolConfig.setMinEvictableIdleTimeMillis(redisConfigProperties.getMinEvictableIdleTimeMillis());
        // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
        jedisPoolConfig.setNumTestsPerEvictionRun(redisConfigProperties.getNumTestsPerEvictionRun());
        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(redisConfigProperties.getTimeBetweenEvictionRunsMillis());
        // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        jedisPoolConfig.setTestOnBorrow(redisConfigProperties.isTestOnBorrow());
        // 在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(redisConfigProperties.isTestWhileIdle());

        return jedisPoolConfig;
    }


    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("127.0.0.1");
        redisStandaloneConfiguration.setPort(6379);
        //  redisStandaloneConfiguration.setDatabase(1);
        redisStandaloneConfiguration.setPassword(RedisPassword.none());


        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().
                poolConfig(jedisPoolConfig).and().
                readTimeout(Duration.ofMillis(1800))
                .build();

        //哨兵
//        RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration();
//        JedisConnectionFactory jedisConnectionFactory =
//                new JedisConnectionFactory(sentinelConfiguration,jedisClientConfiguration);
//        return new JedisConnectionFactory(sentinelConfiguration,jedisClientConfiguration);

        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);

    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        //设置序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.activateDefaultTyping(om.getPolymorphicTypeValidator());
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);//key序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);//value序列化

        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);//Hash value序列化
        redisTemplate.setHashKeySerializer(stringSerializer);//Hash key序列化
        redisTemplate.afterPropertiesSet();
        return redisTemplate;

    }

    //缓存管理器
    //配置了5分钟过期策略
    @Bean
    public RedisCacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {

        return RedisCacheManager.builder(jedisConnectionFactory).cacheDefaults(
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1))).transactionAware()
                .build();
    }


    /**
     * @return 自定义策略生成的key
     * @description 自定义的缓存key的生成策略
     * 若想使用这个key  只需要讲注解上keyGenerator的值设置为keyGenerator即可</br>
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                System.out.println();
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    @ConditionalOnClass(RedisTemplate.class)
    @ConditionalOnMissingBean
    @Bean
    public RedisService redisService() {
        return new RedisService();
    }


    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.redisConfigProperties = applicationContext.getBean(RedisConfigProperties.class);
    }
}
