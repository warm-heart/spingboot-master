package com.example.ajax.controller;




/**
 * 控制层通用结构
 *
 * @author wangqianlong
 * @create 2019-05-01 19:05
 */
//@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private Integer code;

    private String msg;

    private T data;

    public static <T> ApiResponse<T> success(T object) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setData(object);
        apiResponse.setCode(200);
        apiResponse.setMsg("ok");
        return apiResponse;
    }




    public static <T> ApiResponse<T> error(Integer code, String msg) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(code);
        apiResponse.setMsg(msg);
        return apiResponse;
    }

    public static <T> ApiResponse<T> error(String msg) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(500);
        apiResponse.setMsg(msg);
        return apiResponse;
    }




    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
