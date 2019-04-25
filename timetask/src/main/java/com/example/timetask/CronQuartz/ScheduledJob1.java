package com.example.timetask.CronQuartz;

import org.quartz.*;
import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2019-04-22 16:10
 */
@Component
@DisallowConcurrentExecution
public class ScheduledJob1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobKey key = jobExecutionContext.getJobDetail().getKey();//获取JobDetail的标识信息
        System.out.println("JobDetail‘s name and group are " + key.getName() + ":" + key.getGroup());
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();//获取Trigger的标识信息
        System.out.println("Trigger‘s name and group are " + triggerKey.getName() + ":" + triggerKey.getGroup());


        JobDetail jobDetail = jobExecutionContext.getJobDetail();

        System.out.println(jobDetail.getJobDataMap().getString("UserName"));
    }
}
