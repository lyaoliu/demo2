package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.Dao;
import com.example.demo.dao.RoleMapper;
import com.example.demo.entity.Role;
import com.example.demo.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/08 上午 9:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {
   /* @Autowired
    private RoleMapper repository;*/
    @Autowired
    private Dao dao;
    @Test
    public void testInsert() {
        Role role = new Role();
        role.setName("管理员");
        role.setDescr("测试2");
      //  this.repository.insert(role);
        dao.insert("role.insertRole",role);
        System.out.println(role);
    }
   @Test
    public void query(){
        List list= this.dao.queryForList("role.listRole",null);
        System.out.println(JSON.toJSONString(list));
    }
   /* @Test
    public void testFindOne() {
       // Optional<Role> role = this.repository.findById(2);
        System.out.println(role.get());
        System.out.println(role.get().toString());
    }

    @Test
    public void testUpdate() {
        Role role = new Role();
        role.setId(1);
        role.setName("管理员");
        role.setDescr("控制权限");
        Role result = this.repository.save(role);
        System.out.println(result);
    }
*/
    @Test
    public void testDelete() {
        this.dao.delete("role.deleteById",3);
    }
    @Test
    public void testRedis(){
        //List list= RedisUtil.hmgetPattern("LON_LAT_");
      //  System.out.println(JSON.toJSONString(list));
        Object o=RedisUtil.hmGet("LON_LAT_CN510116099001001","5101773985");
        System.out.println(o);
     /*  RedisUtil.delPattern("123");
        RedisUtil.set("123","测试");
        RedisUtil.set("1234","测试232");
       List o= RedisUtil.getAll("123");
        System.out.println(o);*/

    }
   @Test
    public void test() throws InterruptedException {
        long a=System.currentTimeMillis();
        Thread.sleep(1000);
        System.out.println(1);
        System.out.println((System.currentTimeMillis()-a)/1000D);
    }

}
