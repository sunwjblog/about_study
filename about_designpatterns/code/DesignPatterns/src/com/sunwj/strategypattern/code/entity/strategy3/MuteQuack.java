package com.sunwj.strategypattern.code.entity.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 9:52 下午
 */
public class MuteQuack implements Quackable {
    @Override
    public void quack() {
        System.out.println("鸭子不会叫......");
    }
}
