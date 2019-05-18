package com.example.ajax.controller;

import com.example.ajax.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-03-28 16:10
 */
@Controller
public class TestController {



    //ajax 后端接受单参数
    @RequestMapping("/test")
    public String test(String userId) {
        System.out.println("userId是:" + userId);
        return "test";
    }

    //Ajax 后端接受多参数
    //处理test2.html ajax请求
    @RequestMapping("/test2r")
    @ResponseBody
    public String test2r(String userAge, String userName) {
        System.out.println("userId是:" + userAge);
        System.out.println("userName是:" + userName);
        String name = "后端接到请求ajax回调结果是"+userName;
        return name;
    }

    //ajax 后端接受list数组参数
    //处理test3.html ajax请求
    @RequestMapping("/test3r")
    @ResponseBody
    public String test3r(@RequestBody List<Object> list) {
        System.out.println(list);
        String name = "ajax回调结果";
        return name;
    }


    // ajax 后端以实体形式接受参数
    //处理test3.html ajax请求
    @RequestMapping("/test4r")
    @ResponseBody
    public String test4r(@RequestBody List<User> users) {
        System.out.println(users);
        String name = "ajax回调结果";
        return name;
    }


    //ajax 后端接受list数组参数   并返回list结果给前端渲染
    //处理test5.html ajax请求
    @RequestMapping("/test5r")
    @ResponseBody
    public List<User> test5r(@RequestBody List<User> users) {
        System.out.println(users);
        User user = users.get(0);
        List list = new ArrayList();
        list.add("da");
        list.add(1);
        list.remove(0);
        return users;
    }


    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
       /* System.out.println("userId是:"+userAge);
        System.out.println("userName是:"+userName);*/
        System.out.println(request.getParameter("s"));
        return "login";
    }
}
