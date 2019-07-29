package com.example.interceptor.filter;

import com.example.interceptor.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangqianlong
 * @create 2019-07-29 8:31
 */
@Component
public class LoginFilter extends OncePerRequestFilter {
    @Autowired
    UrlService urlService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("业务代码");
        urlService.print();
        filterChain.doFilter(request,response);
    }
}
