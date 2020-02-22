package com.qiming.designpattern.observer;

/**
 * 主题，一对多中的一，负责通知观察者（订阅者）
 *
 * 观察者模式是JDK中用的最多的模式
 *
 * 注意这是一种推的形式，相当于主题直接将信息推给观察者
 */
public interface Subject {

  //注册观察者
  public void registerObserver(Observer o);

  //删除观察者
  public void removeObserver(Observer o);

  //当主题状态改变时，这个方法会被调用，以通知所有观察者
  public void notifyObservers();

}
