package com.example.fileload.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangqianlong
 * @create 2020-04-08 21:33
 */
@Configuration
public class mvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        //可以直接访问静态资源 比如
        // http:localhost:8080/Image/bg-1565082763608.bg.jpg
        registry.addResourceHandler("/music/**")
                .addResourceLocations("file:E:/userIcon/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/musicPlay").setViewName("MusicPlay");
    }
}
