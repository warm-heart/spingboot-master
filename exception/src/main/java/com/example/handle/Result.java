package com.example.handle;

/**
 * @author wangqianlong
 * @create 2019-03-08 19:45
 */

public class Result<T> {
    private int code;

    private String message;

    private  T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(T data ,SeckillStatEnum seckillStatEnum) {
        this.code=seckillStatEnum.getState();
        this.message=seckillStatEnum.getStateInfo();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
