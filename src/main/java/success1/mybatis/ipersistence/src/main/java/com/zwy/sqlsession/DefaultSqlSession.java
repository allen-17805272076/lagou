package com.zwy.sqlsession;

import com.zwy.pojo.Configuration;
import com.zwy.pojo.MappedStatement;

import java.util.List;

public class DefaultSqlSession implements SqlSession{
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public <E> List<E> selectList(String statementid, Object... params) {
        //将要去完成simleExecutor里的query方法的调用
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementid);
        List<E> query = simpleExecutor.query(configuration, mappedStatement);
        return query;
    }

    public <T> T selectOne(String statementid, Object... params) {
        List<Object> objects = selectList(statementid, params);
        if(objects.size()==1){
            return (T) objects.get(0);
        }else{
            throw new RuntimeException("查询结果为空或返回结果过多");
        }
    }
}
