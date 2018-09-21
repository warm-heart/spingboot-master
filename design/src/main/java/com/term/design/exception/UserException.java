package com.term.design.exception;

/**
 * @author wangqianlong
 * @create 2018-07-23 15:48
 */

public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
