package com.extension.springsourcecode;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.stereotype.Component;


/**
 * @author wangqianlong
 * @create 2020-07-09 21:01
 */
@Component
@Slf4j
public class CustomerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class);
        for (String postProcessorName : postProcessorNames) {
            if (postProcessorName.equals("customerBeanPostProcessor")) {
                //do something change customerBeanPostProcessor;
                CustomerBeanPostProcessor.name = "init";
            }
        }
    }
}
