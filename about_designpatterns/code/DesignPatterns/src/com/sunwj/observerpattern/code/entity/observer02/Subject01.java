package com.sunwj.observerpattern.code.entity.observer02;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/29 11:10 上午
 */
public interface Subject01 {

    //注册
    void registerObserver(Observer01 o);

    //通知
    void notifyObserver();

    //删除
    void removeObserver(Observer01 o);
}
