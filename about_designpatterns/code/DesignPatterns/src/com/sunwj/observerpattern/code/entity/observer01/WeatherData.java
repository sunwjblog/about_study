package com.sunwj.observerpattern.code.entity.observer01;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:45 下午
 */
public class WeatherData implements Subject {

    //现在需要一个容器，将"多"的观察者保存进来
    private List<OvserverTest> observer = new ArrayList();

    //温度
    private double temperature;
    //湿度
    private double humidity;
    //气压
    private double pressure;

    public WeatherData(){

    }

    //测量值发生变化
    public void measurementschanged(){
        this.notifyObservers();
    }

    //具体进行数值的变化
    public void setMeasurements(double temperature,double humidity,double pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.measurementschanged();
    }

    @Override
    public void registerObserver(OvserverTest o) {
        System.out.println("注册方法。。。。。");
        this.observer.add(o);
    }

    @Override
    public void notifyObservers() {
        System.out.println("通知方法.......");
        for (OvserverTest observer: this.observer) {
            observer.update(temperature,humidity,pressure);
        }
    }

    @Override
    public void removeObserver(OvserverTest o) {
        System.out.println("删除方法。。。。。");
        this.removeObserver(o);
    }
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
