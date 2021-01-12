package com.sunwjblog.firststatge.mybatis.handwritingframe.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sunwjblog.firststatge.mybatis.handwritingframe.io.Resource;
import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.Configuration;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description SqlMapConfig.xml配置文件解析工具类
 * @date 2021/1/12 1:03 下午
 */
public class XMLConfigBuilder {

    private Configuration configuration;

    public XMLConfigBuilder() {

        this.configuration = new Configuration();
    }

    public Configuration parseConfig(InputStream inputStream) throws Exception {


        Document document = new SAXReader().read(inputStream);
        Element configurationRootElement = document.getRootElement();

        // 解析数据源配置dataSource下的参数信息
        List<Element> elementList = configurationRootElement.selectNodes("//property");
        Properties properties = new Properties();
        for (Element element : elementList){

            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.put(name,value);
        }

        // 使用c3p0数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(properties.getProperty("driverClass"));
        dataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        dataSource.setUser(properties.getProperty("userName"));
        dataSource.setPassword(properties.getProperty("password"));

        // 设置数据源
        configuration.setDataSource(dataSource);

        // 解析mapper.xml，根据路径读取字节输入流，使用dom4j进行解析
        List<Element> mapperElementList = configurationRootElement.selectNodes("//mapper");
        for (Element element : mapperElementList) {

            String mapperPath = element.attributeValue("resource");
            InputStream resourceAsStream = Resource.getResourceAsStream(mapperPath);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            xmlMapperBuilder.parseMapper(resourceAsStream);
        }

        return configuration;
    }
}
