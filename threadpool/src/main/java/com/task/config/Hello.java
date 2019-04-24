package com.task.config;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * @author wangqianlong
 * @create 2019-04-24 14:37
 */

@Component
public class Hello {


    @Async("taskExecutor")
    public void sayHello(String name) {
        LoggerFactory.getLogger(Hello.class).info(name + ":Hello World!");

    }
}
