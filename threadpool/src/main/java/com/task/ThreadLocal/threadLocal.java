package com.task.ThreadLocal;

/**
 * @author wangqianlong
 * @create 2019-04-24 17:11
 */

public class threadLocal {

    ThreadLocal<String> local = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "da";
        }

    };



    String get(){
        return local.get();
    }

    void set(){
        local.set("你好");
    }


}
