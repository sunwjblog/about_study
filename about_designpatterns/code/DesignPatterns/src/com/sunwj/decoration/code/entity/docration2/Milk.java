package com.sunwj.decoration.code.entity.docration2;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/4 10:28 下午
 */
public class Milk extends MyDcoration{

    //定义需要装饰的实体
    Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.1;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ",加牛奶...";
    }
}
