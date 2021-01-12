package com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession;

import com.sunwjblog.firststatge.mybatis.handwritingframe.config.XMLConfigBuilder;
import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.Configuration;

import java.io.InputStream;
/**
 * @author sunwjcoder
 * @version 1.0
 * @description SqlSessionFactory构建者类
 * @date 2021/1/12 1:08 下午
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) throws Exception {


        // 第一步：用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(inputStream);

        // 第二步：创建SqlSessionFactory对象，生产sqlSession会话对象（工厂模式）
        DefaultSqlSessionFactory defaultSqlSessionFactory =
                new DefaultSqlSessionFactory(configuration);

        return defaultSqlSessionFactory;
    }
}
