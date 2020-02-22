package com.qiming.designpattern.observer;

import java.util.Observable;

/**
 * 用JDK内置的"拉"的方式去实现之前的气象台
 */
public class WeatherDataByJDK extends Observable {

  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherDataByJDK() {

  }

  public void measurementsChanged() {
    setChanged();  //标记状态已经改变
    notifyObservers();  //通知所有的观察者
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  /**
   * 使用的是拉的方式，这种就让观察者自己去拉取所要获得的数据
   * @return
   */
  public float getTemperature() {
    return temperature;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }

}
