package com.mtxul.it.methodology.patterns.behavior.observer;

/**
 * target: 定义对象之间的一对多依赖，当一个对象状态改变时，它的所有依赖都会收到通知并且自动更新状态。
 * mind: subject具有注册、删除observe,当修改数据时调用所有observe的update方法，observe创建时会注册到 subject
 *
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(0, 0, 0);
        weatherData.setMeasurements(1, 1, 1);
    }
}

