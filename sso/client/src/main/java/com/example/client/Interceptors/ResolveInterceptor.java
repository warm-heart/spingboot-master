package com.example.client.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangqianlong
 * @create 2019-05-18 9:12
 */
@Component
public class ResolveInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //todo
        //判断request是否含有token字段如果有则表明是sso服务端发过来的 把token存到session表明登陆 放行
        //判断session是否有token信息 如果有则表明已经登陆
        // 再去redis中查找key为token的信息，如果查到 放行  查不到则表明单点退出，携带地址重定向到sso认证服务器，双重验证

        // 如果没有则携带地址重定向到sso认证服务器
       String token= (String) request.getSession().getAttribute("token");
       String PATH=request.getServletPath();
        String URL="http://localhost:8080"+PATH;
        System.out.println(URL);
        if (StringUtils.isEmpty(token)){
            response.sendRedirect("http://localhost:8081?ReturnUrl="+URL);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
