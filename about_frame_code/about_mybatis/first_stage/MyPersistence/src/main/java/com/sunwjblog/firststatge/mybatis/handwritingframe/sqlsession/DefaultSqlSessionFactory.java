package com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession;

import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.Configuration;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description SqlSessionFactory的默认实现类
 * @date 2021/1/12 1:08 下午
 */
public class DefaultSqlSessionFactory implements  SqlSessionFactory{


    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {

        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {

        return new DefaultSqlSession(configuration);
    }
}
