package com.sunwjblog.firststatge.mybatis.handwritingframe.config;
import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.Configuration;
import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description Mapper.xml配置文件解析工具类
 * @date 2021/1/12 1:04 下午
 */
public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {

        this.configuration = configuration;
    }

    public void parseMapper(InputStream inputStream) throws DocumentException {


        Document mapperDocument = new SAXReader().read(inputStream);
        Element rootElement = mapperDocument.getRootElement();
        String namespace = rootElement.attributeValue("namespace");

        // 解析每一个select节点
        List<Element> selectNodes = mapperDocument.selectNodes("//select");
        for (Element element : selectNodes) {

            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String sql = element.getTextTrim();

            // 解析封装进入MapperdStatement对象
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(parameterType);
            mappedStatement.setSql(sql);
            String statementId = namespace + "." + id;
            configuration.getMappedStatementMap().put(statementId,mappedStatement);
        }

    }

}
