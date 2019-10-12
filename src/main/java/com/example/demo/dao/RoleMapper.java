package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/08 下午 3:13
 */
@Repository
@Transactional
public interface RoleMapper {
    /**
     * 新增
     * @param department
     */
    public Role insert(Role department);

    /**
     * 通过ID获取
     * @param id
     * @return
     */
    public Role getById(Integer id);

    /**
     * 更新
     * @param department
     */
    public void update(Role department);

    /**
     * 通过id删除
     * @param id
     */
    public void deleteById(Integer id);
}
