package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/07/23 下午 3:38
 */
@Controller
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        request.getSession();
        return "websocket";
    }
    @RequestMapping("websocket")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        map.put("error","Hello,springBoot");
        return "/websocket";
    }

}