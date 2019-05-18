package com.example.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqianlong
 * @create 2019-05-18 9:09
 */

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

        return "hello";
    }
}
