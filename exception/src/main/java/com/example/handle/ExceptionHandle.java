package com.example.handle;

import com.example.exception.TestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author wangqianlong
 * @create 2018-09-14 20:00
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(TestException.class)
    @ResponseBody
    //让http响应不再是200
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String TestException(Exception e){
        return e.getMessage();
    }



}
