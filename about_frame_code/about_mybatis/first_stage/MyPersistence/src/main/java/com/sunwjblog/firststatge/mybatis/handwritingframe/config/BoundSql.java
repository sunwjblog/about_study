package com.sunwjblog.firststatge.mybatis.handwritingframe.config;

import com.sunwjblog.firststatge.mybatis.handwritingframe.utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description 保存Sql语句的对象，替换sql#{}成为?号并且存储#{}对应的参数名
 * @date 2021/1/12 1:03 下午
 */
public class BoundSql {

    /** * 解析过的sql语句 */
    private String sqlText;

    private List<ParameterMapping> parameterMappingList =
            new ArrayList<ParameterMapping>();

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {

        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }

    public String getSqlText() {

        return sqlText;
    }

    public void setSqlText(String sqlText) {

        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {

        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {

        this.parameterMappingList = parameterMappingList;
    }
}
