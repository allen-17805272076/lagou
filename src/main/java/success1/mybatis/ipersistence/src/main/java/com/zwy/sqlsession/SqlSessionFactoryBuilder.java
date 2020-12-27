package com.zwy.sqlsession;

import com.zwy.config.XmlConfigBuilder;
import com.zwy.pojo.Configuration;

import java.io.InputStream;

/**
 * SqlSessionFactory--->DefaultSqlSessionFactory
 * SqlSession---->DeafultSession
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in) throws Exception {
      //第一：使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);
        //第二：创建sqlSessionFactory对象:工厂类：生产sqlSession：会话对象
        DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        return sqlSessionFactory;
    }
}
