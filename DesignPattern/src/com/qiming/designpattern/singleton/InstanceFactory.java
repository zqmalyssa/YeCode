package com.qiming.designpattern.singleton;

/**
 * 延迟初始化方案，Initialization On Demand Holder idiom
 *
 */
public class InstanceFactory {

  private static class InstanceHolder {
    private static Instance instance = new Instance();
  }

  public static Instance getInstance() {
    return InstanceHolder.instance; //这里将导致InstanceHolder类被初始化
  }

}

class Instance {

}
