package com.sunwj.strategypattern.code.entity.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 9:42 下午
 */
public class FlyNoWay implements Flyable {
    @Override
    public void fly() {
        System.out.println("不会飞.....");
    }
}
