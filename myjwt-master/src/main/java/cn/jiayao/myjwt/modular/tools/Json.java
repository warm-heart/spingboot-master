package cn.jiayao.myjwt.modular.tools;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/12/29.
 */

public class Json<T> {
    /** OK */
    public static Json<Object> CODE_200 = new Json<Object>(Apistatus.CODE_200);
    /*参数错误*/
    public static Json<Object> CODE_400 = new Json<Object>(Apistatus.CODE_400);
    /** 没有权限 */
    public static Json<Object> CODE_401 = new Json<Object>(Apistatus.CODE_401);
    /** Internal Server Error */
    public static Json<Object> CODE_500 = new Json<Object>(Apistatus.CODE_500);

    public static <T> Json<T> newInstance(T result) {
        return new Json<T>(result);
    }

    public static <K> Json<Map<String, Object>> newInstance(K result, Page page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageSize", page.getPageSize());
        map.put("pageNum", page.getPageNum());
        map.put("total", page.getTotal());
        map.put("data", result);
        return new Json<Map<String, Object>>(map);
    }

    public static <K> Json<Map<String, Object>> newInstance(K result, Page page, Object extra) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageSize", page.getPageSize());
        map.put("pageNum", page.getPageNum());
        map.put("total", page.getTotal());
        map.put("data", result);
        map.put("extra", extra);
        return new Json<Map<String, Object>>(map);
    }


    public static <K> Json<Map<String, Object>> newInstance(Apistatus apistatus) {
        return new Json<Map<String, Object>>(apistatus);
    }

    public static <K> Json<Map<String, Object>> newInstance() {
        return new Json<Map<String, Object>>();
    }


    public static <T> Json<T> newInstance(Map<String, String> errors, String extra) {
        return new Json<T>(errors, extra);
    }

    private int apistatus;
    private String msg;
    private T data;
    private Map<String, String> errors;

    private Json(Apistatus apistatus) {
        this.apistatus = apistatus.getCode();
        this.msg = apistatus.getMsg();
    }
    private Json() {
        this.apistatus = Apistatus.CODE_200.getCode();
        this.msg = Apistatus.CODE_200.getMsg();
    }
    private Json(T data) {
        this.apistatus = Apistatus.CODE_200.getCode();
        this.msg = Apistatus.CODE_200.getMsg();
        this.data = data;
    }

    private Json(Map<String, String> errors, String extra) {
        this.apistatus = Apistatus.CODE_400.getCode();
        this.msg = Apistatus.CODE_400.getMsg()+ " ("+extra+")";
        this.errors = errors ;
    }

    public int getApistatus() {
        return apistatus;
    }

    public void setApistatus(int apistatus) {
        this.apistatus = apistatus;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}