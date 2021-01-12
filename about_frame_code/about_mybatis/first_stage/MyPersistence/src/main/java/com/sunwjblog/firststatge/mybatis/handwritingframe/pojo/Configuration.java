package com.sunwjblog.firststatge.mybatis.handwritingframe.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/**
 * @author sunwjcoder
 * @version 1.0
 * @description 封装SqlMapConfig.xml配置参数
 * @date 2021/1/12 1:05 下午
 */
public class Configuration {

    private DataSource dataSource;

    /** * key:statementId * value:封装好的mappedStatement对象 */
    private Map<String,MappedStatement> mappedStatementMap = new HashMap<String, MappedStatement>();

    public DataSource getDataSource() {

        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {

        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {

        this.mappedStatementMap = mappedStatementMap;
    }
}
