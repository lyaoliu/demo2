package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private JavaMailTest test;
    @Test
    public void Test() throws MessagingException {
        String content="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"></meta>\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  THIS IS SPRINGBOOT PROJECT!!!\n" +
                "</body>\n" +
                "</html>";
        String file="F:\\文档\\消费服务功能（投标）.docx";
        test.send("",content,file);
    }

}
