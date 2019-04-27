package com.example.interceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangqianlong
 * @create 2019-04-27 17:45
 */
@Controller
public class CorfController {

    Logger logger = LoggerFactory.getLogger(CorfController.class);

    @RequestMapping("/crof")
    @ResponseBody
    @CrossOrigin
    public String test2r(String userAge, String userName) {
        logger.info("userId是:" + userAge);
        logger.info("userName是:" + userName);
        String name = "后端接到请求ajax回调结果是"+userName;
        return name;
    }

}
