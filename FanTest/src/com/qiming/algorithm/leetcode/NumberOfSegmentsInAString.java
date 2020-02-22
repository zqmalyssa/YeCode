package com.qiming.algorithm.leetcode;

/**
 * 字符串中的单词数
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例: 输入: "Hello, my name is John" 输出: 5
 *
 * 思路：找单词的起始标志，是下标前为空格，下标不为空格，就是字符的开始，但是当0下标是空格的时候也要特殊判断一下
 *
 *
 */
public class NumberOfSegmentsInAString {

  public static void main(String[] args) {
//    String s = "";
    String s = ", , , ,        a, eaefa";
    System.out.println(new NumberOfSegmentsInAString().countSegments(s));
  }

  public int countSegments(String s) {
    int segmentCount = 0;

    for (int i = 0; i < s.length(); i++) {
      if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
        segmentCount++;
      }
    }

    return segmentCount;
  }

}
