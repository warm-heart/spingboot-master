package com.example.redis.dao;

import com.example.redis.RedisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class RedisTest extends RedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private UserDao userDao;

    @Test
    public void findUserByPhone() {
    }

    @Test
    public void insert() {
        redisTemplate.opsForValue().set("aaa", "111");
        redisTemplate.opsForValue().set("bbb", "创建时设置过期时间设置十分钟", 60 * 10, TimeUnit.SECONDS);

        //设置过期时间
        redisTemplate.expire("aaa", 100, TimeUnit.SECONDS);
        //操作list

        List<String> list = new ArrayList();
        list.add("hello");
        list.add("world");
        redisTemplate.opsForList().rightPush("nihao", list);

        //操作hash
        redisTemplate.opsForHash().put("数据库表", "文章", "文章1");
        redisTemplate.opsForHash().put("数据库表", "用户", "用户1");

        Map map = new HashMap();
        map.put("first", "1");
        map.put("two", "2");
        redisTemplate.opsForHash().putAll("数据库表", map);

    }


    @Test
    public void redisPipeline() {
        // 1.executePipelined 重写 入参 RedisCallback 的doInRedis方法
        List<Object> resultList = redisTemplate.executePipelined(new RedisCallback<Object>() {

            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                //                2.connection 打开管道
                connection.openPipeline();

                //                3.connection 给本次管道内添加 要一次性执行的多条命令

                //                3.1 一个set操作
                byte[] key1 = "mykey1".getBytes();
                byte[] value1 = "字符串value".getBytes();
                connection.set(key1, value1);

                //                3.2一个批量mset操作
                Map<byte[], byte[]> tuple = new HashMap<>();
                tuple.put("m_mykey1".getBytes(), "m_value1".getBytes());
                tuple.put("m_mykey2".getBytes(), "m_value2".getBytes());
                tuple.put("m_mykey3".getBytes(), "m_value3".getBytes());
                connection.mSet(tuple);

                // 3.3一个get操作
                connection.get("m_mykey2".getBytes());

                //  4.关闭管道 不需要close 否则拿不到返回值
                //connection.closePipeline();

                //这里一定要返回null，最终pipeline的执行结果，才会返回给最外层
                return null;
            }
        });


        //5.最后对redis pipeline管道操作返回结果进行判断和业务补偿
        for (Object str : resultList) {
            System.out.println(String.valueOf(str));
        }
    }

    @Test
    @Cacheable(value = "dada")
    public void findUserByName() {
        System.out.println(userDao.findUserByName("1"));
    }

    @Test
    public void redisLua() {
//        RedisScript script = RedisScript
//                .of(new ClassPathResource("redis.lua")) ;
        List<String> keys = Arrays.asList("hello");
        RedisScript script = RedisScript
               .of(" return redis") ;
        Object o = redisTemplate.execute(script, keys, "world");
        System.out.println(o);
    }

    @Test
    public  void setIfAbsent(){
        boolean res = redisTemplate.opsForValue().setIfAbsent("name", "va", 1L, TimeUnit.HOURS);
        System.out.println(res);
    }
}