package com.qiming.algorithm;

/**
 * A到Z分别是65到90，十六进制的话是41到5a
 * a到z分别是97到122，十六进制的话是61到7a
 */
public class MaxMinExpression {

  public static void main(String[] args) {
    String s = "leetcode";
    //对于s1这样的特殊字串，最大表示法，会选择第一个c，所以，在字串后面加一个ASCII码比a小的，可以是. 如代码中
    String s1 = "bcac";
    String s2 = "abab";
    System.out.println(new MaxMinExpression().maxRepresent(s1));

  }

  //最小表示法
  public int minRepresent(String s) {
    int n = s.length();
    int i = 0, j = 1, k = 0;
    while (i < n && j < n && k < n) {
      int t = s.charAt((i+k)%n) - s.charAt((j+k)%n);
      if (t == 0) {
        k++;
      } else {
        if (t > 0) {
          i += k+1;
        } else {
          j += k+1;
        }
        if (i == j) {
          j++;
        }
        k = 0;
      }
    }
    return i < j ? i : j;
  }

  //最大表示法
  public int maxRepresent(String s) {
//    s = s + ".";
    int n = s.length();
    int i = 0, j = 1, k = 0;
    while (i < n && j < n && k < n) {
      int t = s.charAt((i + k) % n) - s.charAt((j + k) % n);
      if (t == 0) {
        k++;
      } else {
        if (t > 0) {
          j += k + 1;
        } else {
          i += k + 1;
        }
        if (i == j) {
          j++;
        }
        k = 0;
      }
    }
    return i < j ? i : j;
  }
}
