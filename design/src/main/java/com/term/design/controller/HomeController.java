package com.term.design.controller;

import com.term.design.entity.Msg;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqianlong
 * @create 2018-07-28 17:39
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }

    @RequestMapping("/admin")
    public String hello() {
        return "hello admin";
    }

   /* @RequestMapping("/login")
    public String login() {
        return "login";
    }*/

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getList() {
        return "hello getList";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String save() {
        return "hello save";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String update() {
        return "hello update";
    }
}
