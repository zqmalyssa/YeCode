package com.qiming.algorithm;

/**
 * 求1+2+…+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 输入: n = 3 输出: 6
 *
 * 思路：短路原则。。（就是与或者或条件的优先判断，，这tm叫短路）
 *
 */
public class SumNums {

  public int sumNums(int n) {

    int result = 0;
    boolean b = n > 0 && (result = n + sumNums(n-1)) > 0;
    return result;

  }

}
