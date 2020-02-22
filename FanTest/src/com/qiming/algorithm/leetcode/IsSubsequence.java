package com.qiming.algorithm.leetcode;

/**
 * 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:  s = "abc", t = "ahbgdc"  返回 true.
 *
 * 思路：两个指针，如果s的指针走完了，说明在t中能找到这样的序列
 *
 */
public class IsSubsequence {

  public boolean isSubsequence(String s, String t) {
    int i = 0,j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    if (i == s.length()) {
      return true;
    } else {
      return false;
    }
  }

}
