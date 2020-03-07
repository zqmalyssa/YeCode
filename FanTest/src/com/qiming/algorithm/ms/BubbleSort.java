package com.qiming.algorithm.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 有多个值的比较方法，先以age作为比较值，再以score作为比较值
 *
 * 还有冒泡排序的两种写法
 *
 */
public class BubbleSort {

  public static void main(String[] args) {

    Student s1 = new Student(10, 20);
    Student s2 = new Student(10, 40);
    Student s3 = new Student(10, 10);
    Student s4 = new Student(11, 30);
    Student s5 = new Student(9, 25);

    Student students[] = new Student[7];
    students[0] = s1;
    students[1] = s2;
    students[2] = s3;
    students[3] = s4;
    students[4] = s5;
    Student s6 = new Student(10, 50);
    Student s7 = new Student(11, 60);
    students[5] = s6;
    students[6] = s7;

    new BubbleSort().bubbleSortStudentFromBigToSmall(students);

    for (Student student : students) {
      System.out.println(student.getAge() + " " + student.getScore());
    }




    List<Student> list = new ArrayList<>();
    list.add(s1);
    list.add(s2);
    list.add(s3);
    list.add(s4);
    list.add(s5);

    //先按年级从大到小排，再按分数从大到小排
    Collections.sort(list, new Comparator<Student>() {
      @Override
      public int compare(Student o1, Student o2) {
        if (o1.getAge() == o2.getAge()) {
          return o2.getScore() - o1.getScore();
        } else {
          return o2.getAge() - o1.getAge();
        }
      }
    });

    for (Student student : list) {
      System.out.println(student.getAge() + " " + student.getScore());
    }

    int arr[] = {5,3,2,1,6,8,9,7};
    new BubbleSort().bubbleSortFromSmallToBig(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();

    new BubbleSort().bubbleSortFromBigToSmall(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  //由小到到排序
  public void bubbleSortFromSmallToBig(int arr[]) {

    //假设是8个数，那么一共其实就是7次大移动
    for (int i = 1; i < arr.length; i++) {
      //而每次呢，就是找一个最大的数，扔到最后一位，所以最后一位是要变的每次，注意i是从1开始的
      for (int j = 0; j <= arr.length - 1 -i; j++) {
        if (arr[j] > arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }

  }

  //由大到小排序
  public void bubbleSortFromBigToSmall(int arr[]) {

    //由大到小，反方向排列，次数也是一样的，8个数，7次大移动
    for (int i = 1; i < arr.length; i++) {
      //而每次呢，也是找一个最大的数，扔到第一位，注意下标的判断和j--
      for (int j = arr.length -1; j >= i ; j--) {
        if (arr[j] > arr[j-1]) {
          int temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
        }
      }
    }

  }

  //所以如果从大到小换成学生案例的话
  public void bubbleSortStudentFromBigToSmall(Student arr[]) {

    //由大到小，反方向排列，次数也是一样的，8个数，7次大移动
    for (int i = 1; i < arr.length; i++) {
      //而每次呢，也是找一个最大的数，扔到第一位，注意下标的判断和j--
      for (int j = arr.length -1; j >= i ; j--) {
        if (arr[j].compareTo(arr[j-1]) < 0) {
          Student temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
        }
      }
    }

  }

}


class Student implements Comparable {

  private int age;
  private int score;

  public Student(int age, int score) {
    this.age = age;
    this.score = score;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public int compareTo(Object o) {
    Student s = (Student)o;
    if (this.getAge() == s.getAge()) {
      return s.getScore() - this.getScore();
    } else {
      return s.getAge() - this.getAge();
    }
  }
}