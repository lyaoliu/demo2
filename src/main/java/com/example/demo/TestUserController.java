package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/02 下午 2:44
 */
@RestController
@EnableAutoConfiguration
public class TestUserController {
    @RequestMapping("/getuser")
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("jack");
        user.setPassword("jack123");
        user.setBirthday(new Date());

        return user;
    }
}
