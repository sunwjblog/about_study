package com.sunwj.observerpattern.code.entity.observer01;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:49 下午
 */
public interface OvserverTest {

    //设置更新天气信息
    public void update(double temperature,double humidity,double pressure);
}
