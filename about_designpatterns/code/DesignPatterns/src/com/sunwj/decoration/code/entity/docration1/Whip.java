package com.sunwj.decoration.code.entity.docration1;

import com.sunwj.decoration.code.entity.docration1.Beverage;
import com.sunwj.decoration.code.entity.docration1.MyDecoration;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/4 10:05 下午
 */
public class Whip extends MyDecoration {

    //装饰者，要获取其自身将要装饰哪一个主体，需要吧这个主体拿过来
    //不仅仅可以获取主体饮料本身，当主体饮料倍装饰以后，仍然可以在这里被套进来，进行继续装饰
    Beverage beverage;

    //初始化 主体饮料（含已经装饰的情况下）
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    //需要将被修饰的成本 加 自身的成本
    @Override
    public double cost() {

        return 0.5 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",奶泡..";
    }
}
