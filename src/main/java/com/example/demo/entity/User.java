package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/02 下午 2:40
 */
public class User {
    private Integer id;

    private String username;

    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
