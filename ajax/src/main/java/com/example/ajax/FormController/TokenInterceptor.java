package com.example.ajax.FormController;


import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author wangqianlong
 * @create 2019-08-13 8:38
 */

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //第一步：获得调用处理方法的注解
        HandlerMethod hm = (HandlerMethod) handler;
        TokenForm tokenForm = hm.getMethodAnnotation(TokenForm.class);


        //第二步：判断是否有Token注解
        if (tokenForm != null) {
            HttpSession session = request.getSession();
            if (tokenForm.create() == true) {
                session.setAttribute("token", UUID.randomUUID().toString());
               // log.debug("打印出来的token:" + session.getAttribute("token"));
            }
            if (tokenForm.remove() == true) {
                //判断表单的Token与服务端的Token是否相同
                String formToken = request.getParameter("token");
                Object sessionToken = session.getAttribute("token");
                //传递过来的Token与服务端的Token相同，允许操作，并且删除session的Token
                if (formToken.equals(sessionToken)) {
                    session.removeAttribute("token");
                } else {
                    //跳转到指定的路径
                    String invoke = request.getParameter("token.invoke");
                    response.sendRedirect(request.getContextPath() + invoke);
                    return false;
                }
            }

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
