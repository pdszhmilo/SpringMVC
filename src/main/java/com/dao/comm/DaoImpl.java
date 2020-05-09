package com.dao.comm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DaoImpl implements Dao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    public void insert(String servicename, Map<String, Object> params) {

        sqlSession.insert(servicename, params);
    }

    public List<Map<String, Object>> selectList(String servicename) {
        return this.sqlSession.selectList(servicename);
    }

    public Map<String, Object> selectOne(String servicename) {

        return (Map) this.sqlSession.selectOne(servicename);
    }

    public void update(String servicename, Map<String, Object> params) {
        this.sqlSession.update(servicename, params);
    }
}
