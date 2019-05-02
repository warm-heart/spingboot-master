package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangqianlong
 * @create 2019-05-02 20:15
 */

public class DistributedServiceDemo {

    private static final int TIMEOUT = 10 * 1000;  //超时时间  10s

    @Autowired
    private RedisLock redisLock;

    /**
     * 业务代码
     * 分布式 高并发场景 如秒杀场景 代码需要同步 不能出现超卖
     */
    public void service() throws InterruptedException {

        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;

        String productId = "具体业务中的唯一主键 如秒杀项目中商品id";

        if (!redisLock.lock(productId, String.valueOf(time))) {
            //获取不到锁 业务抛出异常让稍后再试
            throw new RuntimeException("人太多了，请稍后再试~~");
        }

        //模拟业务代码
        Thread.sleep(1000);
        System.out.println("业务执行中");


        //解锁
        redisLock.unlock(productId, String.valueOf(time));


    }
}
