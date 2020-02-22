package com.qiming.test.annoation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注解处理器
 */

public class PasswordUtil {

  @UseCase(id = 47, description = "test 1")
  public boolean validatePassword(String password) {
    return true;
  }

  @UseCase(id = 48)
  public String encryptPassword(String password) {
    return "password";
  }

  @UseCase(id = 49, description = "test 3")
  public boolean checkForNewPassword() {
    return false;
  }

  public static void trackUserCases(List<Integer> useCases, Class<?> cl) {
    //第一个反射
    for (Method method : cl.getDeclaredMethods()) {
      //第二个反射，返回指定类型的注解对象，在这里就是UseCase
      UseCase uc = method.getAnnotation(UseCase.class);
      if (uc != null) {
        System.out.println("Found Use Case: " + uc.id() + " " + uc.description() );
        useCases.remove(new Integer(uc.id()));
      }
    }
    for (int i : useCases) {
      System.out.println("Warning: Missing use case-" + i);
    }
  }

  public static void main(String[] args) {
    List<Integer> useCases = new ArrayList<Integer>();
    Collections.addAll(useCases, 47, 48, 49, 50);
    trackUserCases(useCases, PasswordUtil.class);
  }

}
