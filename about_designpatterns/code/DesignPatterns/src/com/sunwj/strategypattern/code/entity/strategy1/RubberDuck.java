package com.sunwj.strategypattern.code.entity.strategy1;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 8:53 下午
 */
public class RubberDuck extends Duck{


    //复写父类 描述自身能力
    public void fly(){
        System.out.println("橡皮鸭不会飞.....");
    }
    @Override
    public void display() {
        System.out.println("橡皮鸭display......");
    }


}
