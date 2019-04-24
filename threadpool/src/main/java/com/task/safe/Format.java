package com.task.safe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * @author wangqianlong
 * @create 2019-04-24 15:45
 */

public class Format {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String FormatDate(Date date) {
        //return threadLocal.get().format(date);
        return dateFormat.format(date);
    }

    public Date parse(String date) throws ParseException {
        return dateFormat.parse(date);
    }

    /* public static void main(String[] args) {
     *//*  ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i <20 ; i++) {
            service.execute(() ->{
                for (int j = 0; j < 10; j++) {
                    try {
                        //System.out.println(Format.parse("2018-01-02 09:09:07"));
                        System.out.println(Format.FormatDate(new Date()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }*/
}
