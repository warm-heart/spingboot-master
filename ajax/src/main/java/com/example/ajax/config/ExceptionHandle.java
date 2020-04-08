package com.example.ajax.config;


import com.example.ajax.controller.ApiResponse;
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

    @ExceptionHandler(Exception.class)
    @ResponseBody
    //让http响应不再是200
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse TestException(Exception e) {
        return ApiResponse.error("未授权,请登录");
    }


}
