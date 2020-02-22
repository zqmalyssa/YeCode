package com.qiming.test.datastructureAndAlgorithm.common;

public interface Strategy {

  //判断两个元素是否相等
  public boolean equal(Object obj1, Object obj2);

  //比较两个元素的大小，如果obj1<obj2 返回-1 如果想当，返回0，如果obj1>obj2，返回1
  public int compare(Object obj1, Object obj2);

}
