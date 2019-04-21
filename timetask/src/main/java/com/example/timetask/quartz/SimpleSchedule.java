package com.example.timetask.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangqianlong
 * @create 2019-04-21 20:52
 */
@Configuration
public class SimpleSchedule {

    @Bean
    public JobDetail generateJobDetail() {
        return JobBuilder.newJob(SimpleJob.class).withIdentity("simpleJob")
                .usingJobData("name", "World").storeDurably().build();
    }

    @Bean
    public Trigger simpleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();
        return TriggerBuilder.newTrigger().forJob(generateJobDetail())
                .withIdentity("simpleJobTrigger").withSchedule(scheduleBuilder).build();
    }

}
