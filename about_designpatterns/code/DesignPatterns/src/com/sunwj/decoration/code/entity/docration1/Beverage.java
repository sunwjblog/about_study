package com.sunwj.decoration.code.entity.docration1;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/4 9:58 下午
 */
public abstract class Beverage {

    //定义描述属性
    String description = "未知饮料";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //定价：抽象方法

    public abstract  double cost();
}
