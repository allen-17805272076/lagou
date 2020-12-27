package com.zwy.test;

import com.zwy.io.Resources;

import java.io.InputStream;

public class IPersistenceTest {
    public void test(){
        InputStream resuource = Resources.getResuourceAsStream("sqlMapConfig.xml");
    }
}
