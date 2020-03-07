package com.qiming.algorithm;

/**
 * 正则表达式匹配
 *
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 输入: s = "aa" p = "a" 输出: false 解释: "a" 无法匹配 "aa" 整个字符串。
 * 输入: s = "aab" p = "c*a*b" 输出: true 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 输入: s = "mississippi" p = "mis*is*p*." 输出: false
 *
 * 思路：回溯或者动态规划 hard？？
 *
 */
public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {

    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[s.length()][p.length()] = true;

    for (int i = s.length(); i >= 0; i--){
      for (int j = p.length() - 1; j >= 0; j--){
        boolean first_match = (i < s.length() &&
            (p.charAt(j) == s.charAt(i) ||
                p.charAt(j) == '.'));
        if (j + 1 < p.length() && p.charAt(j+1) == '*'){
          dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
        } else {
          dp[i][j] = first_match && dp[i+1][j+1];
        }
      }
    }
    return dp[0][0];


  }

}
