package com.sunwj.observerpattern.code.entity.observer02;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/29 11:17 上午
 */
public class WangYiDisplay implements DisplayElement,Observer01{

    private Subject01 weatherdata;

    private double tem;

    private double pre;

    public WangYiDisplay(WeatherData01 myWeatherData){
        this.weatherdata = myWeatherData;
        myWeatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("网易天气预报：温度：" + this.tem + " 气压: "+this.pre);
    }

    @Override
    public void update(double tem, double humi, double q) {
        this.tem = tem;
        this.pre = q;
        this.display();
    }
}
