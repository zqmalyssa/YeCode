package com.qiming.test.hashmap;

public final class ImmutableDemo {

  private final int[] myArray;

  public ImmutableDemo(int[] array) {
//    this.myArray = array;  //这种方法是错的，因为myArray和array指向同一块内存，可以在外部修改array，所以要进行深拷贝

    this.myArray = array.clone(); //深度copy
  }
}
