package com.qiming.algorithm;

/**
 * 计算一个数组中的差值最大时，条件是只能左边减右边的数或者只能右边减左边的数，一次遍历就应该能完成
 */
public class MaxDIffOfArray {

  public static void main(String args[]) {

    int[] num1 = {1,4};
//    System.out.println(max_difference_left_to_right(num1));
    System.out.println(max_difference_right_to_left(num1));

  }

  //从左往右减
  private static int max_difference_left_to_right(int[] s) {
    int len = s.length;
    if (len < 2) {
      return 0;
    }
    int min = Math.min(s[len - 1], s[len - 2]);
    int max_diff = s[len - 2] - s[len - 1];
    for (int i = len - 3; i > 0; i--) {
      if (s[i] - min > max_diff) {
        max_diff = s[i] - min;
      }
      if (s[i] < min) {
        min = s[i];
      }
    }
    return max_diff;
  }

  //从右往左减
  private static int max_difference_right_to_left(int[] s) {
    int len = s.length;
    if (len < 2) {
      return 0;
    }
    int min = Math.min(s[0], s[1]);
    int max_diff = s[1] - s[0];

    for (int i = 2; i < len; i++) {
      if (s[i] - min > max_diff) {
        max_diff = s[i] - min;
      }
      if (s[i] < min) {
        min = s[i];
      }
    }
    return max_diff;
  }


}
