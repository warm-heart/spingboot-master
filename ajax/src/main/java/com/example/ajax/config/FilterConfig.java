package com.example.ajax.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




/**
 * @author wangqianlong
 * @create 2019-07-29 8:32
 */
@Configuration
public class FilterConfig {

    @Autowired
    @Qualifier("loginFilter")
    private LoginFilter loginFilter;

    @Autowired
    @Qualifier( "CorsFilter")
    private CorsFilter corsFilter;


    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(corsFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("CorsFilter");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(loginFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("LoginFilter");
        registrationBean.setOrder(2);

        return registrationBean;
    }


}
