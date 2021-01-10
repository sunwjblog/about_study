package com.sunwj.decoration.code.entity.docration2;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/4 10:24 下午
 */
public abstract class Beverage {

    String description = "未知饮料";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double cost();
}
