package com.sunwj.strategypattern.lx01.code.strategy1;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:17 下午
 */
public class MaiarheadDuck extends Duck{

    public void fly(){
        System.out.println("橡皮鸭不会飞....");
    }

    @Override
    public void display() {
        System.out.println("我是橡皮鸭.....");
    }
}
