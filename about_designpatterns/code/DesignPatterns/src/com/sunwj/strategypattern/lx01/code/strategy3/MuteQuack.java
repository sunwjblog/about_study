package com.sunwj.strategypattern.lx01.code.strategy3;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:29 下午
 */
public class MuteQuack implements Quackable{
    @Override
    public void quack() {
        System.out.println("不会叫......");
    }
}
