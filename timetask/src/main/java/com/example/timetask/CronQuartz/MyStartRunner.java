package com.example.timetask.CronQuartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2019-04-22 16:30
 */

@Component
public class MyStartRunner implements CommandLineRunner {

    @Autowired
    private MySchedule mySchedule;

    @Override
    public void run(String... args) throws Exception {
        mySchedule.startScheduleTask();
    }
}
