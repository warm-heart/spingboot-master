package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;



import org.springframework.web.bind.annotation.*;

/**
 * @author wangqianlong
 * @create 2018-06-29 14:07
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

/*    @Autowired
    private UserService userService;


    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Result<Userdto> getUserByPhone(Model model) {
        Result<Userdto> result ;
        try {
            User user = userService.findUserByPhone("12345678910");
            Userdto userdto=new Userdto(ConfigEnum.SUCCESS,user);
            result= new Result<Userdto>(true,userdto);
        }catch (UserException e1){
            Userdto userdto =new Userdto(ConfigEnum.ERROR);
            return new Result<Userdto>(true,userdto);
           *//*
           如果throw e1 会给前端service层中的没有此用户信息；
           throw e1;
           *//*
        }
         return  result;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
       userService.insert(user);
       return "成功";

    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(Model model) {
       // Userdto Userdto =new Userdto(ConfigEnum.ERROR);
     *//*   User user = userService.findUserByName("Cooper");
        return user;*//*

        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }*/



}
