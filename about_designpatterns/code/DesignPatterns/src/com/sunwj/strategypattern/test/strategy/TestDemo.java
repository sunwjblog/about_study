package com.sunwj.strategypattern.test.strategy;

import com.sunwj.strategypattern.code.entity.strategy1.MaiarheadDuck;
import com.sunwj.strategypattern.code.entity.strategy1.RubberDuck;
import com.sunwj.strategypattern.code.entity.strategy3.*;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 8:51 下午
 */
public class TestDemo {

    public static void main(String[] args) {

        RedheadDuck redheadDuck = new RedheadDuck();
        redheadDuck.display();
        redheadDuck.setQuackableBehavior(new Quack());
        redheadDuck.performQuack();
        redheadDuck.setFlyableBehavior(new FlyWithWings());
        redheadDuck.performFly();
        redheadDuck.swim();
        System.out.println("-------------------------------");
        ModelDuck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.performQuack();
        modelDuck.performFly();
        modelDuck.swim();
        modelDuck.setQuackableBehavior(new Squeak());
        modelDuck.performQuack();
        modelDuck.setFlyableBehavior(new FlyRocketPower());
        modelDuck.performFly();
        
    }
}
