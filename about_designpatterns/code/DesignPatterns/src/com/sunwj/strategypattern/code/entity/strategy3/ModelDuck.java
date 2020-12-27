package com.sunwj.strategypattern.code.entity.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 10:13 下午
 */
public class ModelDuck extends Duck{

    public ModelDuck(){
        this.quackableBehavior = new Quack();
        this.flyableBehavior = new FlyNoWay();
    }
    @Override
    public void display() {
        System.out.println("我是模型鸭子......");
    }
}
