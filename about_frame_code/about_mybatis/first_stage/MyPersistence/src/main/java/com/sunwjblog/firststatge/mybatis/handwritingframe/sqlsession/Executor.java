package com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession;

import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.Configuration;
import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.MappedStatement;

import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description Executor接口sql的真正执行者，使用JDBC操作数据库
 * @date 2021/1/12 1:07 下午
 */
public interface Executor {

    public <E> List<E> query(Configuration configuration,
                             MappedStatement mappedStatement,
                             Object... params) throws Exception;
}
