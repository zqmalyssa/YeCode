package com.qiming.designpattern.observer;

/**
 * 展示接口，根据变化的数据实时展示，注意！！可能有多种展示方式，不要写的太死
 */
public interface DisplayElement {

  //当布告板需要展示时，调用此方法
  public void display();

}
