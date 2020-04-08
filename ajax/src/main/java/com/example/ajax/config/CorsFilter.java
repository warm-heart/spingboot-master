package com.example.ajax.config;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangqianlong
 * @create 2019-11-13 10:44
 */
@Component(value = "CorsFilter")
public class CorsFilter extends OncePerRequestFilter {

    static final String ORIGIN = "Origin";

    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        System.out.println("跨域过滤器执行了");

        String origin = request.getHeader(ORIGIN);

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");//* or origin as u prefer
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "content-type,authorization,token");

        if (request.getMethod().equals("OPTIONS"))
            response.setStatus(HttpStatus.NO_CONTENT.value());
        else
            filterChain.doFilter(request, response);

    }
}
