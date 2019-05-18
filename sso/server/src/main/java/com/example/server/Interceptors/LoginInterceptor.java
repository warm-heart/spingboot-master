package com.example.server.Interceptors;

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
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //todo
        //判断session中是否已经登陆 如果有登陆 拿出token 作为参数重定向至原来url
        //如果未登录 则跳转至登陆页面 并把url作为隐藏参数传给表单里的隐藏属性

        String ReturnUrl = request.getParameter("ReturnUrl");

        String token = (String) request.getSession().getAttribute("token");
        if (StringUtils.isEmpty(token)) {
            response.sendRedirect("toLogin?ReturnUrl=" +ReturnUrl);

            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
