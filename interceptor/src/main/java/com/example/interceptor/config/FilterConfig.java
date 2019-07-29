package com.example.interceptor.config;

import com.example.interceptor.filter.LoginFilter;
import com.example.interceptor.filter.SafeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-07-29 8:32
 */
@Configuration
public class FilterConfig {

    @Autowired
    private LoginFilter loginFilter;

    @Autowired
    private SafeFilter safeFilter;


    @Bean
    public FilterRegistrationBean myFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(loginFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("LoginFilter");
        List<String> stringList = new ArrayList<>();
        //  stringList.add("/*");
        //stringList.add("/user/*");
        //registrationBean.addUrlPatterns(stringList);
        registrationBean.setOrder(1);
        //registrationBean.setEnabled(false);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myOncePerRequestFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(safeFilter);
        List<String> urlList = new ArrayList<String>();
        urlList.add("/*");
        registrationBean.setUrlPatterns(urlList);
        // registrationBean.addUrlPatterns("/*");
        registrationBean.setName("SafeFilter");
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
