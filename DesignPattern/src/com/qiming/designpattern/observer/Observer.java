package com.qiming.designpattern.observer;

/**
 * 观察者，一对多中的多
 */
public interface Observer {

  //当气象观测值改变时，主题会把这些状态值当作方法的参数，传递给观察者
  public void update(float temp, float humidity, float pressure);

}
