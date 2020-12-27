package com.zwy.sqlsession;

import java.io.InputStream;

/**
 * SqlSessionFactory--->DefaultSqlSessionFactory
 * SqlSession---->DeafultSession
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in){
      //第一：使用dom4j解析配置文件，将解析出来的内容封装到Configuration中

        //第二：创建sqlSessionFactory对象
        return null;
    }
}
