package com.sunwj.decoration;

import com.sunwj.decoration.code.entity.docration1.*;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/4 9:44 下午
 */
public class test {

    public static void main(String[] args) {

        Beverage beverage = new HouseBlend();
        System.out.println(beverage.getDescription()+"\t金额" + beverage.cost());
        System.out.println("---------------------------------");
        //开始进行装饰
        beverage = new Milk(beverage);
        beverage = new Milk(beverage);
        beverage = new Milk(beverage);
        beverage = new Milk(beverage);
        beverage = new Milk(beverage);
        beverage = new Whip(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription()+"\t金额" + beverage.cost());


    }
}
