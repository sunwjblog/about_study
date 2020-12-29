package com.sunwj.observerpattern.code.entity.observer03;

import java.util.Observable;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/29 11:34 上午
 */
public class WeatherData extends Observable {

    //List observer容器
    //利用内置的观察者，不需要

    //温度
    private double temperature;
    //湿度
    private double humidity;
    //气压
    private double pressure;

    //具体进行数值的变化
    public void setMeasurements(double temperature,double humidity,double pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.measurementschanged();
    }

    private void measurementschanged() {
        this.setChanged();
        this.notifyObservers();
    }

    //对两个方法进行复写
    //setChange()
    //notifyObserver()


    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
