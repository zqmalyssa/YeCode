package com.qiming.test.annoation;

@DBTable(name = "MEMBER")
public class Member {

  @SQLString(30)
  String firstName;

  @SQLString(50)
  String listName;

  @SQLInteger
  Integer age;

  @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
  String handle;

  static int memeberCount;

  public String getFirstName() {
    return firstName;
  }

  public String getListName() {
    return listName;
  }

  public Integer getAge() {
    return age;
  }

  public String getHandle() {
    return handle;
  }

  public String toString() {
    return handle;
  }
}
