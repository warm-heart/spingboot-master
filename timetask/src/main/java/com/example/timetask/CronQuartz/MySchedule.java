package com.example.timetask.CronQuartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2019-04-22 16:16
 */

@Component
public class MySchedule {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    private void schedulejob1(Scheduler scheduleler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class)
                .withIdentity("job1", "groupName")
                .usingJobData("UserName", "cooper")
                .build();


        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/6 * * * * ?");


        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("job1", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduleler.scheduleJob(jobDetail, cronTrigger);

    }


    public void startScheduleTask() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        schedulejob1(scheduler);

    }
}
