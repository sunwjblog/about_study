package com.sunwj.observerpattern.code.entity.observer01;




/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/28 11:48 下午
 */
public class BaiduDisplay implements OvserverTest,DisplayElement {

    //必须要和主题有一个关联
    private Subject weatherData;

    //温度
    private double temperature;

    //湿度
    private double humidity;

    //在开始的时候，将当前的显示面板就注册到通知主题上面
    public BaiduDisplay(Subject mySubject){
        this.weatherData = mySubject;
        mySubject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("baidu display....温度:"+this.temperature + " 湿度: "+this.humidity);
    }


    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.display();
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
}
