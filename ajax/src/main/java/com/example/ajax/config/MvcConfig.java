package com.example.ajax.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangqianlong
 * @create 2019-04-11 12:28
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/test2").setViewName("test2");
        registry.addViewController("/test3").setViewName("test3");
        registry.addViewController("/test4").setViewName("test4");
        registry.addViewController("/test5").setViewName("test5");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/corf").setViewName("crof");
        registry.addViewController("/toApi").setViewName("api");
    }


}
