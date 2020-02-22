package com.qiming.test.equalandhashcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 无论何时，对同一个对象调用hashCode()都应该产生同样的值。如果在讲一个对象用put()添加进HashMap时产生一个hashCdoe值，
 * 而用get()取出时却产生了另一个hashCode值，那么就无法获取该对象了。所以如果你的hashCode方法依赖于对象中易变的数据，
 * 用户就要当心了，因为此数据发生变化时，hashCode()方法就会生成一个不同的散列码
 *
 */
class People{
  private String name;
  private int age;

  public People(String name,int age) {
    this.name = name;
    this.age = age;
  }

  public void setAge(int age){
    this.age = age;
  }

  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return name.hashCode()*37+age;
  }

  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    return this.name.equals(((People)obj).name) && this.age== ((People)obj).age;
  }
}

public class PeopleTest {

  public static void main(String[] args) {

    People p1 = new People("Jack", 12);
    System.out.println(p1.hashCode());

    HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
    hashMap.put(p1, 1);
    //易变，设置完后，hashcode值都不一样了，自然取不到值
    //注意这句话 无论何时，对同一个对象调用hashCode()都应该产生同样的值。
    p1.setAge(13);
    System.out.println(p1.hashCode());

    System.out.println(hashMap.get(p1));
  }
}