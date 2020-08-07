package com.extension.springsourcecode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2020-07-09 21:01
 */
@Component
@Slf4j
public class CustomerBeanPostProcessor implements BeanPostProcessor, InitializingBean {

    public static String name = null;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Bean)
            return null;
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("init {}",name);
    }
}
