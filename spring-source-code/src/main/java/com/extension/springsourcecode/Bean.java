package com.extension.springsourcecode;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2020-07-23 21:53
 */

@Component
public class Bean implements InitializingBean {
    @Value("${value}")
    private String value;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(value);
    }
}
