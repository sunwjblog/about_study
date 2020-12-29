package com.sunwj.observerpattern.code.entity.observer01;

import java.util.Observer;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/29 10:19 上午
 */
public interface Subject {

    void registerObserver(OvserverTest o);

    void notifyObservers();

    void removeObserver(OvserverTest o);
}
