package com.zwy.sqlsession;

import com.zwy.config.BoundSql;
import com.zwy.pojo.Configuration;
import com.zwy.pojo.MappedStatement;
import com.zwy.utils.GenericTokenParser;
import com.zwy.utils.ParameterMapping;
import com.zwy.utils.ParameterMappingTokenHandler;
import com.zwy.utils.TokenHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SimpleExecutor implements  Executor {
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws SQLException {
        //1、注册驱动，获取连接
        Connection connection = configuration.getDataSource().getConnection();
        //2、获取sql内容
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);
        //3、获取预处理对象：prepareStatement
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
        //4、设置参数
        //5、执行sql
        //6、封装返回结果集
        return null;
    }
    /*
      完成对#{}的解析工作：1、将#{}使用？进行代替  2、解析出#{}里面的值进行存储
     */
    private BoundSql getBoundSql(String sql){
        //标记处理类：配置标记解析器来完成对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        String parseSql = genericTokenParser.parse(sql);
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        BoundSql boundSql = new BoundSql();
        boundSql.setSqlText(parseSql);
        boundSql.setParameterMappingList(parameterMappings);
        return boundSql;
    }
}
