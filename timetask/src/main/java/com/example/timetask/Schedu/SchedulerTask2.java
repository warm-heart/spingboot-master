package com.example.timetask.Schedu;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author wangqianlong
 * @create 2019-04-21 18:30
 */

public class SchedulerTask2 {

    /*@Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
      @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
      @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，
      之后按fixedRate的规则每6秒执行一次*/

    // private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        //System.out.println("现在时间：" + dateFormat.format(new Date()));
        //System.out.println("现在时间： " + threadLocal.get().format(new Date()));
        System.out.println("现在时间："+formatter.format(LocalDateTime.now()));
    }
}
