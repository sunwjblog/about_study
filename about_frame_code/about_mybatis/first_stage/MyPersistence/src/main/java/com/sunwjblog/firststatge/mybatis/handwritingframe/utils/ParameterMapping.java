package com.sunwjblog.firststatge.mybatis.handwritingframe.utils;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description 来源于Mybatis框架，SQL参数映射类，存储#{}、${}中的参数名
 * @date 2021/1/12 1:11 下午
 */
public class ParameterMapping {

    private String content;

    public ParameterMapping(String content) {

        this.content = content;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }
}
