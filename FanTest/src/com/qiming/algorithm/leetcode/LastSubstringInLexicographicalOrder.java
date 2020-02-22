package com.qiming.algorithm.leetcode;

/**
 *  按字典序排在最后的子串
 *
 *  给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 *
 *  示例 1：输入："abab" 输出："bab" 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 *  示例 2: 输入："leetcode" 输出："tcode"
 *
 *  思路：要求字典序最大的子串，那么一定是该字符串的一个后缀子串，因为如果是中间的一个字串的话，那么只要向它后面添加字母，它的字典序一定会更大。这个理解
 *
 *  然后问题转化为如何求的字典序最大的后缀子串，就是最大表示法，但是要处理下字符串，最后加一个比'a'小的'.'
 *
 */
public class LastSubstringInLexicographicalOrder {

  public String lastSubstring(String s) {
    s = s + ".";
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
    int begin = i < j ? i : j;
    return s.substring(begin);
  }

}
