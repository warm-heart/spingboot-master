package com.task.ThreadLocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * @author wangqianlong
 * @create 2019-04-24 15:45
 */

public class SimpleFormatTest {
//jdk8 线程安全
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    //jdk8 之前simpleformat要用ThredLocal
    static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };



    public String FormatDate(Date date) {
        return threadLocal.get().format(date);

    }

    public Date parse(String date) throws ParseException {
        return threadLocal.get().parse(date);

    }

}
