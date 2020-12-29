package com.sunwj.observerpattern.code.entity.observer03;


import com.sunwj.observerpattern.code.entity.observer01.DisplayElement;
import com.sunwj.observerpattern.code.entity.observer01.OvserverTest;
import com.sunwj.observerpattern.code.entity.observer01.Subject;

import java.util.Observable;
import java.util.Observer;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:48 下午
 */
public class BaiduDisplay implements Observer,DisplayElement {

    //温度
    private double temperature;

    //湿度
    private double humidity;

    //让观察者和信息发布者取得联系
    Observable observable;

    //在开始的时候，将当前的显示面板就注册到通知主题上面
    public BaiduDisplay(Observable mySubject){
        this.observable = mySubject;
        observable.addObserver(this);
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

    @Override
    public void update(Observable o, Object arg) {
        //拉数据的方式 借助外部对象实现
        if (o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.display();
        }
    }

    public void display() {
        System.out.println("baidu display....温度:"+this.temperature + " 湿度: "+this.humidity);
    }

}
