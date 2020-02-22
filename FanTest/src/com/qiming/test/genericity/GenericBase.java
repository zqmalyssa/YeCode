package com.qiming.test.genericity;

import java.util.ArrayList;
import java.util.Date;

public class GenericBase<T> {

  private T element;
  public void set(T arg) {
    element = arg;
  }

  public T get() {
    return element;
  }

  public static void main(String[] args) throws Exception{
    Derived2 d2 =  new Derived2();
    Object obj = d2.get();
    d2.set(obj);

    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

//    list.add("test");

    //通过反射是可以添加其他类型元素的
    //原始类型是Object，所以通过反射我们就可以存储字符串了
    list.getClass().getMethod("add", Object.class).invoke(list, "asd");

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    /**不指定泛型的时候*/
    int i = GenericBase.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
    Number f = GenericBase.add(1, 1.2); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
    Object o = GenericBase.add(1, "asd"); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

    /**指定泛型的时候*/
    int a = GenericBase.<Integer>add(1, 2); //指定了Integer，所以只能为Integer类型或者其子类
//    int b = GenericBase.<Integer>add(1, 2.2); //编译错误，指定了Integer，不能为Float
    Number c = GenericBase.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float


//    testRelaod(123);
//    testReload(123);

  }

  //这是一个简单的泛型方法
  public static <T> T add(T x,T y){
    return y;
  }

  public void test1() {
    ArrayList<String> list1 = new ArrayList();
    list1.add("1"); //编译通过
//    list1.add(1); //编译错误
    String str1 = list1.get(0); //返回类型就是String

    ArrayList list2 = new ArrayList<String>();
    list2.add("1"); //编译通过
    list2.add(1); //编译通过
    Object object = list2.get(0); //返回类型就是Object

    new ArrayList<String>().add("11"); //编译通过
//    new ArrayList<String>().add(22); //编译错误

    String str2 = new ArrayList<String>().get(0); //返回类型就是String
  }

  public void test2() {
    ArrayList<Object> list1 = new ArrayList<Object>();
    list1.add(new Object());
    list1.add(new Object());
//    ArrayList<String> list2 = list1; //编译错误
  }

  public void testReload(Object obj) {
    System.out.println(obj);
  }

  public void testRelaod(Object data) {
    System.out.println(data);
  }

  public void testRelaod(Date date) {
    System.out.println(date);
  }


}
