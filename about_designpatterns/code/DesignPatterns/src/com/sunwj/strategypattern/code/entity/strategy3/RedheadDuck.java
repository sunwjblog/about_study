package com.sunwj.strategypattern.code.entity.strategy3;

import com.sunwj.strategypattern.code.entity.strategy2.Flyable;
import com.sunwj.strategypattern.code.entity.strategy2.Quackable;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/27 8:49 下午
 */
public class RedheadDuck extends Duck {

    //如何让鸭子叫和具体的叫声进行结合？

    public RedheadDuck(){
        this.quackableBehavior = new Quack();
        this.flyableBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("红头鸭子向大家问好.....");
    }
}
