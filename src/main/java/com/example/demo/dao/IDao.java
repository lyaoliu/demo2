package com.example.demo.dao;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/08 下午 2:48
 */
@Repository
public interface IDao {
    /**
     * 查询语句返回list
     * @param sql
     * @param obj
     * @return
     */
    public List queryForList(String sql,Object obj);

    /**
     * 修改接口
     * @param sql
     * @param obj
     * @return
     */
    public int update(String sql,Object obj);

    /**
     * 删除接口
     * @param sql
     * @param obj
     * @return
     */
    public int delete(String sql,Object obj) ;

    /**
     * 新增接口
     * @param sql
     * @param obj
     * @return
     */
    public int insert(String sql,Object obj);

    /**
     * 查询返回map
     * @param sql
     * @param obj
     * @return
     */
    public Object queryForObject(String sql,Object obj);

    public List queryForPage(String sql, Object obj, RowBounds rowBounds);
    public List queryForPage(String sql, Object obj);
}
