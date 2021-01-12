package com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description 生产SqlSession的工厂接口
 * @date 2021/1/12 1:07 下午
 */
public interface SqlSessionFactory {

    public SqlSession openSession();
}
