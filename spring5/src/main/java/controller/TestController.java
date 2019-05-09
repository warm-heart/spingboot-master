package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TestService;


/**
 * @author wangqianlong
 * @create 2019-05-08 13:56
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping(value="test", produces = "application/json; charset=utf-8")
    public String test() {
        return "hello spring5 返回json";
    }

    @GetMapping("/test1")
    public String test1() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/test2")
    public String test2() {
        return testService.service();
    }
}
