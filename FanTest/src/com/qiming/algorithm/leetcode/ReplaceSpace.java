package com.qiming.algorithm.leetcode;

/**
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."  输出："We%20are%20happy."
 *
 *
 * 思路：用一个sb即可，正则，replace应该都行
 *
 */
public class ReplaceSpace {

  public String replaceSpace(String s) {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        sb.append("%20");
      } else {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();


  }

}
