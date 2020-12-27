package com.zwy.config;

import com.zwy.utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

public class BoundSql {
    private String sqlText;//解析过的sql
    private List<ParameterMapping>  parameterMappingList=new ArrayList<ParameterMapping>();

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
        this.parameterMappingList = parameterMappingList;
    }

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }

    public BoundSql() {
    }
}
