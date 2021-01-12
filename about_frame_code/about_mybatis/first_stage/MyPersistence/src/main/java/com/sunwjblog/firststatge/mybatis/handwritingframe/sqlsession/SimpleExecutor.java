package com.sunwjblog.firststatge.mybatis.handwritingframe.sqlsession;

import com.mysql.cj.util.StringUtils;
import com.sunwjblog.firststatge.mybatis.handwritingframe.config.BoundSql;
import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.Configuration;
import com.sunwjblog.firststatge.mybatis.handwritingframe.pojo.MappedStatement;
import com.sunwjblog.firststatge.mybatis.handwritingframe.utils.GenericTokenParser;
import com.sunwjblog.firststatge.mybatis.handwritingframe.utils.ParameterMapping;
import com.sunwjblog.firststatge.mybatis.handwritingframe.utils.ParameterMappingTokenHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author sunwjcoder
 * @version 1.0
 * @description Executor的实现类
 * @date 2021/1/12 1:10 下午
 */
public class SimpleExecutor implements Executor {


    @Override
    public <E> List<E> query(Configuration configuration,
                             MappedStatement mappedStatement,
                             Object... params) throws Exception {


        // 1、注册驱动 , 获取数据库连接
        Connection connection = configuration.getDataSource().getConnection();

        // 2、获取sql语句： select * from user where id = #{id}
        // 转换sql语句： select * from user where id = ?
        // 转换的过程，还需要对#{}里面的值进行解析存储
        String sql = mappedStatement.getSql();
        BoundSql bounSql = getBoundSql(sql);

        // 3、获取预处理对象: preparedStatement
        PreparedStatement preparedStatement =
                connection.prepareStatement(bounSql.getSqlText());

        // 4、设置参数，通过反射机制获取到参数
        String parameterType = mappedStatement.getParameterType();
        Class<?> parameterTypeClass = getClassType(parameterType);

        List<ParameterMapping> parameterMappingList =
                bounSql.getParameterMappingList();
        for (int i = 0; i < parameterMappingList.size(); i++) {

            ParameterMapping parameterMapping = parameterMappingList.get(i);
            String filedName = parameterMapping.getContent();

            // 反射
            Field declaredField = parameterTypeClass.getDeclaredField(filedName);
            // 暴力访问
            declaredField.setAccessible(true);
            Object declaredFieldValue = declaredField.get(params[0]); // params[0] 是对象
            preparedStatement.setObject(i+1,declaredFieldValue);
        }

        // 5、执行SQL
        ResultSet resultSet = preparedStatement.executeQuery();
        String resultType = mappedStatement.getResultType();
        Class<?> resultTypeClass = getClassType(resultType);
        List<Object> objects = new ArrayList<Object>();

        // 6、封装返回结果集
        while (resultSet.next()){

            Object o = resultTypeClass.newInstance();
            // 元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {

                // 字段名
                String columnName = metaData.getColumnName(i);
                // 字段值
                Object columnValue = resultSet.getObject(columnName);

                // 使用内省（反射），根据数据库表和实体的对应关系，完成封装
                PropertyDescriptor propertyDescriptor =
                        new PropertyDescriptor(columnName, resultTypeClass);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(o,columnValue);
            }
            objects.add(o);
        }
        return (List<E>)objects;
    }

    /** * 根据参数的全路径反射获取类 * @param parameterType * @return */
    private Class<?> getClassType(String parameterType) throws ClassNotFoundException {

        if (StringUtils.isNullOrEmpty(parameterType)) {

            return null;
        }
        Class<?> clazz = Class.forName(parameterType);
        return clazz;
    }

    /** * 完成对#{}的解析工作：1、将#{}使用？进行代替，2、解析出#{}里面的值并存储 * @param sql * @return */
    private BoundSql getBoundSql(String sql) {


        // 标记处理类，配置标记解析器来完成对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler
                = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser =
                new GenericTokenParser("#{","}",
                        parameterMappingTokenHandler);

        // 解析出来的sql
        String parseSql = genericTokenParser.parse(sql);
        // 解析出来的参数名称
        List<ParameterMapping> parameterMappings =
                parameterMappingTokenHandler.getParameterMappings();

        // 封装成为通配sql返回结果
        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;
    }
}
