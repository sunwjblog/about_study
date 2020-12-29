package com.sunwj.observerpattern.code.entity.observer02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/29 11:11 上午
 */
public class WeatherData01 implements Subject01 {

    //创建容器，装载观察者
    List<Observer01> observer01List = new ArrayList<>();

    //温度
    private double tem;

    //湿度
    private double hum;

    //气压
    private double pre;

    //测量值发生变化
    public void measurementschanged(){
        this.notifyObserver();
    }


    //自身变化通知到所有人
    public void setMeasurements(double tem,double hum,double pre){
        this.hum = hum;
        this.tem = tem;
        this.pre = pre;
        this.measurementschanged();
    }

    @Override
    public void registerObserver(Observer01 o) {
        this.observer01List.add(o);
    }

    @Override
    public void notifyObserver() {

        for (Observer01 o:
             observer01List) {
            o.update(this.tem,this.hum,this.pre);
        }
    }

    @Override
    public void removeObserver(Observer01 o) {
        this.observer01List.remove(0);
    }

    public List<Observer01> getObserver01List() {
        return observer01List;
    }

    public void setObserver01List(List<Observer01> observer01List) {
        this.observer01List = observer01List;
    }

    public double getTem() {
        return tem;
    }

    public void setTem(double tem) {
        this.tem = tem;
    }

    public double getHum() {
        return hum;
    }

    public void setHum(double hum) {
        this.hum = hum;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }
}
