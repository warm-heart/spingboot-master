package com.example.ajax.controller;

import com.example.ajax.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-03-28 16:10
 */
@Controller
public class Test {


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //ajax 后端接受单参数
    @RequestMapping("/test")
    public String test(String userId) {
        System.out.println("userId是:" + userId);

        return "test";
    }

    //Ajax 后端接受多参数
    //跳转test2.html
    @RequestMapping("/test2")
    public String test2() {
       /* System.out.println("userId是:"+userAge);
        System.out.println("userName是:"+userName);*/

        return "test2";
    }

    //处理test2.html ajax请求
    @RequestMapping("/test2r")
    @ResponseBody
    public String test2r(String userAge, String userName) {
        System.out.println("userId是:" + userAge);
        System.out.println("userName是:" + userName);
        String name = "ajax回调结果";
        return name;
    }

    //ajax 后端接受list数组参数
    //跳转test3.html
    @RequestMapping("/test3")
    public String test3() {
       /* System.out.println("userId是:"+userAge);
        System.out.println("userName是:"+userName);*/

        return "test3";
    }

    //处理test3.html ajax请求
    @RequestMapping("/test3r")
    @ResponseBody
    public String test3r(@RequestBody List<Object> list) {
        System.out.println(list);
        String name = "ajax回调结果";
        return name;
    }


    // ajax 后端以实体形式接受参数
    //跳转test4.html
    @RequestMapping("/test4")
    public String test4() {
       /* System.out.println("userId是:"+userAge);
        System.out.println("userName是:"+userName);*/
        return "test4";
    }

    //处理test3.html ajax请求
    @RequestMapping("/test4r")
    @ResponseBody
    public String test4r(@RequestBody List<User> users) {
        System.out.println(users);
        String name = "ajax回调结果";
        return name;
    }


    //ajax 后端接受list数组参数   并返回list结果给前端渲染
    //跳转test5.html
    @RequestMapping("/test5")
    public String test5() {
       /* System.out.println("userId是:"+userAge);
        System.out.println("userName是:"+userName);*/
        return "test5";
    }

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
    public String login() {
       /* System.out.println("userId是:"+userAge);
        System.out.println("userName是:"+userName);*/
        return "login";
    }
}
