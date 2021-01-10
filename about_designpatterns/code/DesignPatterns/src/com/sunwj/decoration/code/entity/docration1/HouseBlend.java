package com.sunwj.decoration.code.entity.docration1;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/4 10:01 下午
 */
public class HouseBlend extends Beverage{

    public HouseBlend(){
        this.description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
