package com.example.exception;

/**
 * @author wangqianlong
 * @create 2018-09-14 19:58
 */

public class TestException extends RuntimeException{
    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }
}
