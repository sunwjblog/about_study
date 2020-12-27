package com.sunwj.strategypattern.code.entity.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 9:50 下午
 */
public class Quack implements Quackable{
    @Override
    public void quack() {
        System.out.println("鸭子嘎嘎叫....");
    }
}
