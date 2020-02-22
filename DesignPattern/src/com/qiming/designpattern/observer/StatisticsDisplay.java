package com.qiming.designpattern.observer;

/**
 * 这是统计布告板
 */
public class StatisticsDisplay implements Observer, DisplayElement{

  private float maxTemperature;
  private float minTemperature;

  private Subject weatherData;

  public StatisticsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Avg/Max/Min temperature = " + (maxTemperature + minTemperature) / 2 + "/" + maxTemperature + "/" + minTemperature);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    if (temp > maxTemperature || 0 == maxTemperature) {
      maxTemperature = temp;
    }

    if (temp < minTemperature || 0 == minTemperature) {
      minTemperature =temp;
    }

    display();
  }
}
