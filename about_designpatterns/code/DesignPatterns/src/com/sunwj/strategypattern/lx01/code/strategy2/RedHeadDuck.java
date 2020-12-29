package com.sunwj.strategypattern.lx01.code.strategy2;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:15 下午
 */
public class RedHeadDuck extends Duck implements Flyable,Quackable {
    @Override
    public void display() {
        System.out.println("我是红头鸭......");
    }


    @Override
    public void fly() {
        System.out.println("红头鸭会飞.....");
    }

    @Override
    public void quack() {
        System.out.println("红头鸭会叫.....");
    }
}
