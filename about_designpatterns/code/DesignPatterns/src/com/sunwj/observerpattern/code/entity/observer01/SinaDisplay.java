package com.sunwj.observerpattern.code.entity.observer01;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:48 下午
 */
public class SinaDisplay implements OvserverTest,DisplayElement{

    //必须要和主题有一个关联
    private Subject weatherData;

    //温度
    private double temperature;

    //气压
    private double pressure;

    public SinaDisplay(Subject mySubject){
        this.weatherData = mySubject;
        mySubject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Sina display....温度:"+this.temperature + " 气压: "+this.pressure);
    }


    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.display();
    }
}
