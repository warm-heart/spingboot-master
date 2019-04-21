package com.example.timetask.Schedu;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2019-04-21 18:15
 */
@Component
public class SchedulerTask {

    private int count=0;

   // @Scheduled(cron="*/6 * * * * ?")  cron表达式
    @Scheduled(cron = "0 */1 * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
