package com.dao.comm;

import java.util.List;
import java.util.Map;

public interface Dao {
    public void insert(String servicename, Map<String, Object> params);

    public List<Map<String, Object>> selectList(String servicename);

    public Map<String, Object> selectOne(String servicename);

    public void update(String servicename, Map<String, Object> params);
}
