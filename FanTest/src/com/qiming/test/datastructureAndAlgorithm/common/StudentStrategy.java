package com.qiming.test.datastructureAndAlgorithm.common;

public class StudentStrategy implements Strategy{

  public boolean equal(Object obj1, Object obj2) {
    if (obj1 instanceof Student && obj2 instanceof Student) {
      Student s1 = (Student)obj1;
      Student s2 = (Student)obj2;
      return s1.getId().equals(s2.getId());
    } else {
      return false;
    }
  }

  public int compare(Object obj1, Object obj2) {
    if (obj1 instanceof Student && obj2 instanceof Student) {
      Student s1 = (Student)obj1;
      Student s2 = (Student)obj2;
      return s1.getId().compareTo(s2.getId());
    } else {
      return obj1.toString().compareTo(obj2.toString());
    }
  }
}
