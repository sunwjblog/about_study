package com.sunwj.strategypattern.code.entity.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 8:48 下午
 */
public abstract class Duck {

    //使用接口类型
    Quackable quackableBehavior;

    Flyable flyableBehavior;
    public void performQuack(){
        this.quackableBehavior.quack();
    }

    public void performFly(){
        this.flyableBehavior.fly();
    }

    public void setQuackableBehavior(Quackable quackableBehavior) {
        this.quackableBehavior = quackableBehavior;
    }

    public void setFlyableBehavior(Flyable flyableBehavior) {
        this.flyableBehavior = flyableBehavior;
    }

    //鸭子会游泳 swim
    public void swim(){
        System.out.println("鸭子会游泳......");
    }

    //抽象方法 display
    public abstract void display();
}
