package com.qiming.test.reflect;

public class User {

    public String name;
    private int age;

    public User(String name, int age) {
      super();
      this.name = name;
      this.age = age;
    }

    private User(int age)
    {
      super();
      this.age = age;

    }

    public User(String name)
    {
      super();
      this.name = name;
    }

    public User() {
      super();
      // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
      return "User [name=" + name + ", age=" + age + "]";
    }

    public void exit()
    {
      System.out.println(name+"退出系统");
    }

    public void login(String username,String password)
    {
      System.out.println("用户名:"+username);
      System.out.println("密码:"+password);
    }

    private String CheckInfo()
    {
      return "年龄:"+age;
    }

}
