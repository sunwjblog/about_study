package com.sunwj.strategypattern.code.entity.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 9:51 下午
 */
public class Squeak implements Quackable{
    @Override
    public void quack() {
        System.out.println("鸭子吱吱叫....");
    }
}
