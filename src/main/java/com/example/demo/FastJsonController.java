package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/03 下午 5:17
 */
@Api(value = "FastJson测试", tags = { "测试接口" })
@RestController
@RequestMapping("fastjson")
public class FastJsonController {
    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
    @RequestMapping ("/test/{name}")
    public User test( @PathVariable String name, HttpServletRequest request ) {
        User user = new User();
        user.setId(1);
        user.setUsername(name);
        user.setPassword("jack123");
        user.setBirthday(new Date());
        return user;
    }
}
