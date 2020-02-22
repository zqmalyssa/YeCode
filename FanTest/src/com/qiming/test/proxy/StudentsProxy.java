package com.qiming.test.proxy;

/**
 * 代理类
 */
public class StudentsProxy implements Person{

  //被代理的学生
  Student stu;

  public StudentsProxy(Person stu) {
    //只代理学生对象
    if (stu.getClass() == Student.class) {
      this.stu = (Student)stu;
    }
  }

  //代理交作业，调用被代理学生的交作业行为，可以在里面进行增强
  @Override
  public void giveTask() {
    System.out.println("强哥最近很猛");
    stu.giveTask();
    System.out.println("老师您检查一下");
  }
}
