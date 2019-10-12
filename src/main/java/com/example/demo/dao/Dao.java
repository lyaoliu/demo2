package com.example.demo.dao;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/08 下午 2:54
 */
@Repository
public class Dao implements IDao {
    @Autowired
    protected SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List queryForList(String sql, Object obj) {
        return sqlSession.selectList(sql,obj);
    }

    @Override
    public int update(String sql, Object obj) {
        return sqlSession.update(sql,obj);
    }

    @Override
    public int delete(String sql, Object obj) {
        return sqlSession.delete(sql,obj);
    }

    @Override
    public int insert(String sql, Object obj) {
        return sqlSession.insert(sql,obj);
    }

    @Override
    public Object queryForObject(String sql, Object obj) {
        return sqlSession.selectOne(sql,obj);
    }

    @Override
    public List queryForPage(String sql, Object obj, RowBounds rowBounds) {
        return sqlSession.selectList(sql,obj,rowBounds);
    }

    @Override
    public List queryForPage(String sql, Object obj) {
        return sqlSession.selectList(sql,obj);
    }
}
