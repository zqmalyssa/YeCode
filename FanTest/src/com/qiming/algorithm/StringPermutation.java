package com.qiming.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例: 输入：s = "abc" 输出：["abc","acb","bac","bca","cab","cba"] 1 <= s 的长度 <= 8
 *
 * 思路：不是经典回溯，或者OF中的递归，注意这里是要去重的。如"aab"
 *
 */
public class StringPermutation {

  private static List<String> res = new LinkedList<>();

  public static void main(String[] args) {
    String s = "aab";
    new StringPermutation().permutation(s);
  }

  public String[] permutation(String s) {

    LinkedList<Character> track = new LinkedList<Character>();
    char[] chars = s.toCharArray();
    //为啥要sort呢
    Arrays.sort(chars);
    backtrack(chars, track, new boolean[s.length()]);
    String[] result = new String[res.size()];
    for (int i = 0; i < res.size(); i++) {
      result[i] = res.get(i);
    }
    return result;
  }

  private static void backtrack(char[] chars, LinkedList<Character> track, boolean[] visited) {
    // 触发结束条件
    if (track.size() == chars.length) {
      StringBuilder sb = new StringBuilder();
      for (Character character : track) {
        sb.append(character);
      }
      res.add(sb.toString());
      return;
    }

    for (int i = 0; i < chars.length; i++) {
      // 在递归时，如果当前字符等于上一次的字符并且上一次的索引已经访问过，那么本次遍历跳过
      if (i != 0 && chars[i] == chars[i-1] && visited[i-1])
        continue;
      if (!visited[i]) {
        track.add(chars[i]);
        visited[i] = true;
        // 进入下一层决策树
        backtrack(chars, track, visited);
        // 取消选择
        track.removeLast();
        visited[i] = false;
      }
    }
  }

}
