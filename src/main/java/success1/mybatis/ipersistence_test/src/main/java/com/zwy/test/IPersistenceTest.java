package com.zwy.test;

import com.zwy.io.Resources;
import com.zwy.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class IPersistenceTest {
    public void test(){
        InputStream resuourceAstream = Resources.getResuourceAsStream("sqlMapConfig.xml");
        new SqlSessionFactoryBuilder().build(resuourceAstream);
    }
}
