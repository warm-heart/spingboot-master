package com.example.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @author wangqianlong
 * @create 2019-04-02 16:53
 */
@Controller
@RequestMapping("/test")
public class testController {

    @RequestMapping("/test2")
    public String test2(HttpServletRequest request){
        request.getSession();
        System.out.println("执行controller");
        return "hello2";
    }


    @RequestMapping("/user")
    @ResponseBody
    public String user(){
        return "拦截到这儿来了";
    }

}
