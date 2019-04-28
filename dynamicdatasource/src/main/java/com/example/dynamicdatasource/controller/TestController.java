package com.example.dynamicdatasource.controller;


import com.example.dynamicdatasource.Service.Test1Service;
import com.example.dynamicdatasource.entity.classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-04-28 22:19
 */

@RestController
public class TestController {
    @Autowired
    private Test1Service test1Service;

    @RequestMapping("/test1")
    public List<classes> test1(){
        return test1Service.find();
    }

    @RequestMapping("/test2")
    public List<classes> test2(){
        return test1Service.find2();
    }
}
