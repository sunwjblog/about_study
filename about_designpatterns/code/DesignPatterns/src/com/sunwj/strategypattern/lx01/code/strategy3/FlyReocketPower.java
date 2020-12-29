package com.sunwj.strategypattern.lx01.code.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:27 下午
 */
public class FlyReocketPower implements Flyable{
    @Override
    public void fly() {
        System.out.println("利用火箭推着飞。。。。");
    }
}
