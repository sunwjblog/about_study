package com.sunwj.observerpattern.code.entity.observer02;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/29 11:22 上午
 */
public class TengXunDisplay implements DisplayElement,Observer01{


    private Subject01 weatherdata;

    private double tem;

    private double hum;

    public TengXunDisplay(WeatherData01 myWeatherData){
        this.weatherdata = myWeatherData;
        myWeatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("腾讯天气预报: 温度： "+this.tem + " 湿度：" + this.hum);
    }

    @Override
    public void update(double tem, double humi, double q) {
        this.tem = tem;
        this.hum = humi;
        this.display();
    }
}
