package com.zwy.sqlsession;

import com.zwy.pojo.Configuration;
import com.zwy.pojo.MappedStatement;

import java.sql.SQLException;
import java.util.List;

public interface Executor {
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,Object... params) throws SQLException;
}
