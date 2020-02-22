package com.qiming.designpattern.observer;

public class WeatherTest {

  public static void main(String[] args) {
    //测试推的方式
    WeatherData weatherData = new WeatherData();
    CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);

    //用JDK自带的测试拉的方式
    WeatherDataByJDK weatherDataByJDK = new WeatherDataByJDK();
    CurrentConditionsDisplayByJDK currentConditionsDisplayByJDK = new CurrentConditionsDisplayByJDK(weatherDataByJDK);
    weatherDataByJDK.setMeasurements(80, 65, 30.4f);
    weatherDataByJDK.setMeasurements(82, 70, 29.2f);
    weatherDataByJDK.setMeasurements(78, 90, 39.2f);
  }

}
