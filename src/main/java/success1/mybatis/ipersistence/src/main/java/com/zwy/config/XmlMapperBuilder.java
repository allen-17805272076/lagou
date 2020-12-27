package com.zwy.config;

import com.zwy.pojo.Configuration;
import com.zwy.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XmlMapperBuilder {
    private Configuration configuration;
    public XmlMapperBuilder(Configuration configuration){
        this.configuration=configuration;
    }
    public void parse(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attributeValue("namespace");
        List<Element> list = rootElement.selectNodes("//select");
        for (Element element:list) {
            String id = element.attributeValue("id");
            String resultType= element.attributeValue("resultType");
            String paramType= element.attributeValue("paramType");
            String sqltext = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramType);
            mappedStatement.setSql(sqltext);
            String key=namespace+id;
            configuration.getMappedStatementMap().put(key,mappedStatement);
        }
    }
}
