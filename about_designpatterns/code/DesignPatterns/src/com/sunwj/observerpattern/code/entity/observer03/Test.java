package com.sunwj.observerpattern.code.entity.observer03;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/29 11:42 上午
 */
public class Test {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        BaiduDisplay baiduDisplay = new BaiduDisplay(weatherData);
        weatherData.setMeasurements(3.0,30.0,29.0);
    }
}
