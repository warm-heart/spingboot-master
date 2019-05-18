package com.example.client.config;



import com.example.client.Interceptors.ResolveInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangqianlong
 * @create 2019-04-02 17:01
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

@Autowired
private ResolveInterceptor resolveInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*纯页面跳转配置，减少controller里的代码*/
        registry.addViewController("/test/test1").setViewName("hello");
        registry.addViewController("/test/test3").setViewName("hello3");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(resolveInterceptor)
                .addPathPatterns("/**");

    }


}
