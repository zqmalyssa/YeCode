package com.qiming.designpattern.observer;

/**
 * 这是天气预告布告板
 */
public class ForecastDisplay implements Observer, DisplayElement{

  private float temperature;

  private Subject weatherData;

  public ForecastDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Forecast: " + "only a test");
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    this.temperature = temp;
    display();
  }
}
