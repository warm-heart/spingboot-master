package com.example.handle;

import com.example.exception.TestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangqianlong
 * @create 2018-09-14 20:00
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(TestException.class)
    @ResponseBody
    public String TestException(Exception e){
        return e.getMessage();
    }



}
