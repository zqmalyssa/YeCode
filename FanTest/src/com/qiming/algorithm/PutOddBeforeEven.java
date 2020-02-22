package com.qiming.algorithm;

/**
 * 奇数全部放到偶数的前面
 * 可以使用两个指针，头部向后直到遇到偶数，尾部向前直到遇到奇数
 */
public class PutOddBeforeEven {

  public static void main(String args[]) {

    int s[] = {1,2,3,4,5,6,7,8,9};
    changeArray(s);
    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }

  }

  private static void changeArray(int s[]) {

    if (s == null || s.length <= 1) {
      return;
    }
    int begin = 0;
    int end = s.length - 1;

    while (begin < end) {
      //向后移动begin，直到它遇到偶数
      while (begin < end && (s[begin] & 1) != 0) {
        begin++;
      }

      //向前移动end，直到它遇到奇数
      while (begin < end && (s[end] & 1) == 0) {
        end--;
      }

      if (begin < end) {
        int temp = s[begin];
        s[begin] = s[end];
        s[end] = temp;
      }
    }

  }

}
