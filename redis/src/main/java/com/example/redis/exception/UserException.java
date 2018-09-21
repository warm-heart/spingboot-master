package com.example.redis.exception;

/**
 * @author wangqianlong
 * @create 2018-07-29 17:06
 */

public class UserException extends RuntimeException{
    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
