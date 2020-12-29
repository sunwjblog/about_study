package com.sunwj.strategypattern.lx01.code.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:15 下午
 */
public class RedHeadDuck extends Duck {

    public RedHeadDuck(){
        this.flyable = new FlyWithWings();
        this.quackable = new Quack();
    }

    @Override
    public void display() {
        System.out.println("红头鸭。。。。。");
    }
}
