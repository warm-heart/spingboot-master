package com.example.timetask.SimpleQuartz;

import com.example.timetask.mail.MailServiceImpl;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

/**
 * @author wangqianlong
 * @create 2019-04-21 20:50
 */

//交给spring容器管理
@Component
//为了不让job并发执行，防止这个任务没有执行完，下一个任务就开始执行
@DisallowConcurrentExecution
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
       /* try {
            mailService.send();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("hello %s", this.name));*/
    }
}
