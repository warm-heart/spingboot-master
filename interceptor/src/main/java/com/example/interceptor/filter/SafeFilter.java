package com.example.interceptor.filter;

import com.example.interceptor.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author wangqianlong
 * @create 2019-07-29 8:56
 */
@Component
public class SafeFilter implements Filter {

    @Autowired
    private UrlService urlService;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行");
        urlService.print();
        chain.doFilter(request,response);
    }
}
