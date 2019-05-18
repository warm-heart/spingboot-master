package com.example.server.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangqianlong
 * @create 2019-05-18 10:12
 */
@org.springframework.stereotype.Controller
public class IndexController {

    @GetMapping("/toLogin")
    public String login(HttpServletRequest request,Model model){
        String ReturnUrl =request.getParameter("ReturnUrl");
        System.out.println("跳转login.html"+ReturnUrl);
        model.addAttribute("ReturnUrl",ReturnUrl);
        return "login";
    }
}
