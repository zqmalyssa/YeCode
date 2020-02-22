package com.qiming.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplayByJDK implements Observer, DisplayElement {

  //这是主题，用拉的方式，观察者中就要存在主题
  Observable observable;
  private float temperature;
  private float humidity;

  public CurrentConditionsDisplayByJDK(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
  }

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof WeatherDataByJDK) {
      WeatherDataByJDK wdj = (WeatherDataByJDK)o;
      this.temperature = wdj.getTemperature();
      this.humidity = wdj.getHumidity();
      display();
    }
  }
}
