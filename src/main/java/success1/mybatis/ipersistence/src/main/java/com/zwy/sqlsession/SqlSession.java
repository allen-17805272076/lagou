package com.zwy.sqlsession;

import java.util.List;

public interface SqlSession {
    //查询所有
    public<E> List<E> selectList(String statementid,Object... params);
    //查询单个
    public<T> T selectOne(String statementid,Object... params);
}
