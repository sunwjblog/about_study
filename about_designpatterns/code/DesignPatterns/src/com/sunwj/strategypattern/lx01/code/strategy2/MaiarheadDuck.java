package com.sunwj.strategypattern.lx01.code.strategy2;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:17 下午
 */
public class MaiarheadDuck extends Duck implements Quackable {


    @Override
    public void display() {
        System.out.println("我是橡皮鸭.....");
    }

    @Override
    public void quack() {
        System.out.println("橡皮鸭会叫....");
    }
}
