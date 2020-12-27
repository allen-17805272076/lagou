package com.zwy.test;

import com.zwy.io.Resources;
import com.zwy.sqlsession.SqlSessionFactory;
import com.zwy.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class IPersistenceTest {
    public void test() throws Exception {
        InputStream resuourceAstream = Resources.getResuourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resuourceAstream);
    }
}
