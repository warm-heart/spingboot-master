package com.example.timetask.CronQuartz;

import org.quartz.*;
import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2019-04-22 16:10
 */
@Component
@DisallowConcurrentExecution
public class ScheduledJob2 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDetail jobDetail = jobExecutionContext.getJobDetail();

        System.out.println(jobDetail.getJobDataMap().getString("UserName"));
    }
}
