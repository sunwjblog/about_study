package com.sunwj.strategypattern.code.entity.strategy1;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 8:48 下午
 */
public abstract class Duck {

    //鸭子叫 quack
    public void  quack(){
        System.out.println("鸭子叫......");
    }

    //鸭子飞 fly
    public void fly(){
        System.out.println("鸭子会飞......");
    }

    //鸭子会游泳 swim
    public void swim(){
        System.out.println("鸭子会游泳......");
    }

    //抽象方法 display
    public abstract void display();
}
