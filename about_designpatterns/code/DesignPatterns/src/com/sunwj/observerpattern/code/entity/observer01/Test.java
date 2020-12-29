package com.sunwj.observerpattern.code.entity.observer01;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2020/12/29 10:37 上午
 */
public class Test {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        BaiduDisplay baiduDisplay = new BaiduDisplay(weatherData);
        SinaDisplay sinaDisplay = new SinaDisplay(weatherData);

        weatherData.setMeasurements(20.0,20.5,100.0);
    }
}
