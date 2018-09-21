package com.example.jpa.controller;

import com.example.jpa.dao.UserDao;
import com.example.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-06-21 18:41
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/name")
    public User test() {
        return userDao.findByName("Cooper");
    }

    @RequestMapping(value = "/all")
    public List<User> all() {
        return userDao.findAll();
    }

}
