package com.example.timetask.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author wangqianlong
 * @create 2019-04-21 21:25
 */
@Service
public class MailServiceImpl {

    @Autowired
    JavaMailSender javaMailSender;

    public void send() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("178625120@qq.com");

        mimeMessageHelper.setTo("2491152384@qq.com");
        // String [] strings ={"2491152384@qq.com","944871142@qq.com"};
        //mimeMessageHelper.setTo(strings);
        mimeMessageHelper.setSubject("张亚楠");
        mimeMessageHelper.setText("big cool", true);

        javaMailSender.send(mimeMessage);

    }

}
