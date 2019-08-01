package com.example.exception;

/**
 * @author wangqianlong
 * @create 2019-08-01 9:42
 */

public class ExceptionFunction {

    public String test() {

        try {
            int i = 10 /0 ;
            return "try";

        } catch (Exception e) {
            throw e;
        }
    }
}
