package com.sunwj.strategypattern.code.entity.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 10:18 下午
 */
public class FlyRocketPower implements Flyable{
    @Override
    public void fly() {
        System.out.println("借助火箭的推力，我上天了.....");
    }
}
