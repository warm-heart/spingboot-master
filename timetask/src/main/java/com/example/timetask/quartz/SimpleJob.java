package com.example.timetask.quartz;

import com.example.timetask.mail.MailServiceImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.mail.MessagingException;

/**
 * @author wangqianlong
 * @create 2019-04-21 20:50
 */

public class SimpleJob extends QuartzJobBean {

    @Autowired
    MailServiceImpl mailService;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            mailService.send();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("hello %s", this.name));
    }
}
