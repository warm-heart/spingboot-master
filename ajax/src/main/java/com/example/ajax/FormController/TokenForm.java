package com.example.ajax.FormController;

/**
 * @author wangqianlong
 * @create 2019-08-13 8:35
 */

public @interface TokenForm {

    //用于标记需要防重提方法的 ，创建Token的属性
    boolean create()  default false;


    //用于标记需要防重提方法的，删除Token的属性
    boolean remove()   default false;


}
