//package com.qiming.test.genericity.interfaces;
//
//import java.util.Iterator;
//import java.util.Random;
//
///**
// * 编写一个Generator<Coffee>接口，随机生成不同类型的Coffee对象
// */
//
//public class CoffeeGenerator implements Generator<Coffee>, Iterator<Coffee> {
//
//  private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
//
//  private static Random rand = new Random(47);
//
//  public CoffeeGenerator() {
//  }
//
//  private int size = 0;
//
//  public CoffeeGenerator(int sz) {
//    this.size = sz;
//  }
//
//  public Coffee next() {
//    try {
//      return (Coffee)types[rand.nextInt(types.length)].newInstance();
//    } catch (Exception e) {
//      //这样throw出去就不会有missing return的错误
//      throw new RuntimeException(e);
//    }
//  }
//
//  class CoffeeIterator implements Iterator<Coffee> {
//    int count = size;
//    public boolean hasNext() {
//      return count > 0;
//    }
//
//    public Coffee next() {
//      count--;
//      return CoffeeGenerator.this.next();
//    }
//
//    public void remove() {
//      throw new UnsupportedOperationException();
//    }
//  };
//
//  public Iterator<Coffee> iterator() {
//    return new CoffeeIterator();
//  }
//
//  public static void main(String[] args) {
//    CoffeeGenerator gen = new CoffeeGenerator();
//    for (int i = 0; i < 5; i++) {
//      System.out.println(gen.next());
//    }
//    for (Coffee coffee : new CoffeeGenerator(5)) {
//      System.out.println(coffee);
//    }
//  }
//
//
//
//}
