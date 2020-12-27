package com.sunwj.strategypattern.code.entity.strategy2;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 8:53 下午
 */
public class RubberDuck extends Duck implements Quackable {


    @Override
    public void display() {
        System.out.println("橡皮鸭display......");
    }

    @Override
    public void quack() {
        System.out.println("鸭子叫......");
    }
}
