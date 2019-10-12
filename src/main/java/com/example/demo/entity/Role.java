package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/08 上午 9:51
 */
@Entity
public class Role implements Serializable {
    private static final  long serialVersionUID=1L;
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String descr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
