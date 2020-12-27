package com.sunwj.strategypattern.code.entity.strategy2;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 8:49 下午
 */
public class RedheadDuck extends Duck implements Flyable, Quackable {

    @Override
    public void display() {
        System.out.println("红头鸭子display......");
    }

    @Override
    public void fly() {
        System.out.println("鸭子飞......");
    }

    @Override
    public void quack() {
        System.out.println("鸭子叫......");
    }
}
