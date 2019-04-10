package org.example.web;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author wangqianlong
 * @create 2019-04-09 16:04
 */

public class RegisterAction {



    public static void main(String[] args) {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());

        System.out.println(simpleDateFormat.format(date));


    }
}
