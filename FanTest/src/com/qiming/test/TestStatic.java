package com.qiming.test;

public class TestStatic {
  private static int x=100;
  public static void main(String args[]){
    TestStatic hs1= new TestStatic();
    //这个是因为x在这个类中。。。换个其他类就不行了啊
    hs1.x++;
    TestStatic  hs2= new TestStatic();
    hs2.x++;
    hs1=new TestStatic();
    hs1.x++;
    TestStatic.x--;
    System.out.println("x="+x);
  }

  private void test() {
    TestStatic test = new TestStatic();
    test.x++;
  }
}
