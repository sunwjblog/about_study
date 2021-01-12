package com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession;

import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.Configuration;
import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;
/**
 * @author sunwjcoder
 * @version 1.0
 * @description SqlSession的实现类
 * @date 2021/1/12 1:09 下午
 */
public class DefaultSqlSession implements SqlSession{


    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {

        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception {


        // 1、构建sql执行器
        SimpleExecutor simpleExecutor = new SimpleExecutor();

        // 2、获取最终执行sql对象
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);

        // 3、执行sql，返回结果集
        List<Object> queryResultList = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>)queryResultList;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {

        List<Object> objects = selectList(statementId, params);
        if (null != objects && objects.size() == 1){

            return (T)objects.get(0);
        } else {

            throw  new RuntimeException("查询结果为空或者返回结果多于1条");
        }
    }

    @Override
    public int update(String statementId, Object... params) {

        return 0;
    }

    @Override
    public int delete(String statementId, Object... params) {

        return 0;
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {


        //使用JDK动态代理来为Dao接口生成代理对象，并返回调用结果
        Object proxyInstance =  Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{
                mapperClass}, new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                // 底层都还是去执行JDBC
                // 根据不同情况，来调用selectList或selectOne
                // 1.准备参数statementId = sql 语句的唯一标识： namespace.id =接口全限定名.方法名
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String statementId = className + "." + methodName;

                // 2.准备参数 params 即args
                // 获取被调用方法的返回值类型
                Type genericReturnType = method.getGenericReturnType();
                // 判断是否进行了 泛型类型参数化
                if ( genericReturnType instanceof ParameterizedType){

                    List<Object> objects = selectList(statementId, args);
                    return objects;
                }

                return selectOne(statementId,args);
            }
        });
        return (T)proxyInstance;

    }
}
