package com.example.controller;

import com.example.exception.TestException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqianlong
 * @create 2018-09-14 19:48
 */
@RestController
public class ExceptionTestController {

    @RequestMapping(value = "/1",method = RequestMethod.GET)
    public void test1(){
           /*这里异常返回是handle里的信息*/
        throw new TestException("controller1");
    }


    /*
    *这个测试异常信息为catch
    * 当有try  catch  返回为catch里的信息
    * */
    @RequestMapping(value = "/2",method = RequestMethod.GET)
    public String test2(){
          int i=2;
        try {
            if (i==1){
                throw new TestException("controller2");
            }
            return "2";
        }catch (TestException e){
          return "catch";
        }
    }

}
