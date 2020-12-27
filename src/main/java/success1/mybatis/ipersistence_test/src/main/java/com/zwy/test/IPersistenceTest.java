package com.zwy.test;

import com.zwy.io.Resources;
import com.zwy.pojo.User;
import com.zwy.sqlsession.SqlSession;
import com.zwy.sqlsession.SqlSessionFactory;
import com.zwy.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class IPersistenceTest {
    public void test() throws Exception {
        InputStream resuourceAstream = Resources.getResuourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resuourceAstream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
       //调用
        User user = new User();
        user.setId(1);
        user.setUsername("allen");
        User user2= sqlSession.selectOne("user.selectOne",user);


    }
}
