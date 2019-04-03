package com.example.ajax.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangqianlong
 * @create 2019-03-19 15:57
 */
@RestController
public class ThreadSafe {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @RequestMapping("/ThreadTest")
    public String Thread(String name, HttpServletRequest request) {
        setUsername(name);
        System.out.println("前端传的name" + name);
        request.getSession().setAttribute("da","你好呀");
        System.out.println("SessionId是"+request.getSession().getId());
        System.out.println(request.getCookies());
        return username;
    }
}
