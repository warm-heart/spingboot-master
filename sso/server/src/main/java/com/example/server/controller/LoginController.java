package com.example.server.controller;


import org.springframework.web.bind.annotation.*;


/**
 * @author wangqianlong
 * @create 2019-05-18 9:09
 */

@RestController
public class LoginController {

    @PostMapping("/login")
    public String test() {
        System.out.println("进入登陆");

        //todo
        //String ReturnUrl = request.getParameter("ReturnUrl");
        // System.out.println("登陆ajax"+ReturnUrl);

        //登陆逻辑

        //用户登陆成功 生成token
        //信息存储到redis key为token
        //session存放token表示用户已经登陆  如果集群可以使用spring-session进行session管理
        // 重定向至子系统url并携带token
        //
        return "hello";
    }


    //todo
    //单点退出
    //清除redis中key为token的信息，子系统找不到redis 则表明退出了  访问受保护资源会重新登陆
}
