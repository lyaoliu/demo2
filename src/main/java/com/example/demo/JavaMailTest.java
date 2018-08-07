package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/06 上午 10:21
 */
@Component
@EnableConfigurationProperties(MailProperties.class)
public class JavaMailTest {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailProperties mailProperties;
    public String send(String email,String text,String filePath) throws MessagingException {
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(message,true,"UTF-8");
        InternetAddress from = new InternetAddress();
        from.setAddress(this.mailProperties.getUsername());
        messageHelper.setFrom(from);
        messageHelper.setTo("lyliu@yinhai.com");
        messageHelper.setSubject("SpringBoot 发送的第二封邮件");
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        messageHelper.addAttachment(fileName,file);
        messageHelper.setText(text, true);
        this.javaMailSender.send(message);
        return text;

    }
}
