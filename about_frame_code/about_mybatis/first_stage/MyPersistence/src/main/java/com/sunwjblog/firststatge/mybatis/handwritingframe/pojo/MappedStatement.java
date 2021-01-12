package com.sunwjblog.firststatge.mybatis.handwritingframe.pojo;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description 封装Mapper.xml配置的sql参数
 * @date 2021/1/12 1:05 下午
 */
public class MappedStatement {

    /** * id标识 */
    private String id;

    /** * 返回值类型 */
    private String resultType;

    /** * 参数值类型 */
    private String parameterType;

    /** * sql语句 */
    private String sql;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getResultType() {

        return resultType;
    }

    public void setResultType(String resultType) {

        this.resultType = resultType;
    }

    public String getParameterType() {

        return parameterType;
    }

    public void setParameterType(String parameterType) {

        this.parameterType = parameterType;
    }

    public String getSql() {

        return sql;
    }

    public void setSql(String sql) {

        this.sql = sql;
    }
}
