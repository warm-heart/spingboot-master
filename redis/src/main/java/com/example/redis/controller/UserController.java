package com.example.redis.controller;

import com.example.redis.dto.Result;
import com.example.redis.dto.Userdto;
import com.example.redis.entity.User;
import com.example.redis.enums.ConfigEnum;
import com.example.redis.exception.UserException;
import com.example.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangqianlong
 * @create 2018-07-29 17:03
 */

@RestController
public class UserController {

    @Autowired
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
           // return new Result<>(false,"da");
           /*
           如果throw e1 会给前端service层中的没有此用户信息；
           throw e1;
           */
        }
        return  result;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        userService.insert(user);
        return "成功";

    }
    @RequestMapping(value = "/add/{id}",method = RequestMethod.GET)
    public void test(@PathVariable("id") int id) {
        Userdto Userdto =new Userdto(ConfigEnum.ERROR);
    }


}

