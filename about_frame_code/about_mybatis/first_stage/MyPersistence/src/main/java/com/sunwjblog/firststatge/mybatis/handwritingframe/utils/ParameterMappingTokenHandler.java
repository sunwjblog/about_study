package com.sunwjblog.firststatge.mybatis.handwritingframe.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description 来源于Mybatis框架，标记处理器实现类，解析#{}、${}成为?
 * @date 2021/1/12 1:12 下午
 */
public class ParameterMappingTokenHandler implements TokenHandler {

    private List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();

    // context是参数名称 #{id} #{username}

    public String handleToken(String content) {

        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }

    private ParameterMapping buildParameterMapping(String content) {

        ParameterMapping parameterMapping = new ParameterMapping(content);
        return parameterMapping;
    }

    public List<ParameterMapping> getParameterMappings() {

        return parameterMappings;
    }

    public void setParameterMappings(List<ParameterMapping> parameterMappings) {

        this.parameterMappings = parameterMappings;
    }
}
