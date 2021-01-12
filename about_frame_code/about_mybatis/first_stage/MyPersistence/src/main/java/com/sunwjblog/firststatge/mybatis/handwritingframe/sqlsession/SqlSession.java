package com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession;

import java.util.List;
/**
 * @author sunwjcoder
 * @version 1.0
 * @description SqlSession接口定义数据库基本的CRUD方法
 * @date 2021/1/12 1:08 下午
 */
public interface SqlSession {

    /** * 查询所有 * @param statementId * @param params * @param <E> * @return */
    public <E> List<E> selectList(String statementId , Object ... params) throws Exception;

    /** * 根据条件查询单个 * @param statementId * @param params * @param <T> * @return */
    public <T> T selectOne(String statementId , Object ... params) throws Exception;

    /** * 根据条件更新 * @param statementId * @param params * @return */
    public int update(String statementId , Object ... params);

    /** * 根据条件删除 * @param statementId * @param params * @return */
    public int delete(String statementId , Object ... params);

    /** * 为Dao接口生成代理实现类 * @param mapperClass * @param <T> * @return */
    public <T> T getMapper(Class<?> mapperClass);
}
