package com.zwy.sqlsession;

import com.zwy.pojo.Configuration;

public class DefaultSqlSessionFactory implements  SqlSessionFactory {
    private Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration){
        this.configuration=configuration;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
