package com.sunwj.strategypattern.lx01.code.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:14 下午
 */
public abstract class Duck {

    public Flyable flyable;

    public Quackable quackable;

    public void performFly(){
        this.flyable.fly();
    }

    public void performQuack(){
        this.quackable.quack();
    }

    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public void setQuackable(Quackable quackable) {
        this.quackable = quackable;
    }

    public abstract void display();
}
