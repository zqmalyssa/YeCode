package com.qiming.test.variantorinvariant;

import java.util.HashSet;
import java.util.Set;

/**
 * ????什么鬼
 */
public class ALeakMemorySample {

  public static void main(String[] args) {
    Set<Person> set = new HashSet<Person>();
    Person p1 = new Person("唐僧","pwd1",25);
    Person p2 = new Person("孙悟空","pwd2",26);
    Person p3 = new Person("猪八戒","pwd3",27);
    set.add(p1);
    set.add(p2);
    set.add(p3);
    System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
    p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变
    set.remove(p3); //此时remove不掉，造成内存泄漏
    for (Person person : set)
    {
      System.out.println(person.getAge());
    }
    set.add(p3); //重新添加，居然添加成功
    System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
    for (Person person : set)
    {
      System.out.println(person.getAge());
    }
  }

}

class Person {
  private int age;
  private String name;
  private String password;

  public Person(String name, String password, int age) {
    this.age = age;
    this.name = name;
    this.password = password;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}