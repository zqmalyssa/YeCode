package com.qiming.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 单词子集
 *
 * 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
 *
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
 * 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。你可以按任意顺序以列表形式返回 A 中所有的通用单词。
 *
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"] 输出：["facebook","google","leetcode"]
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"] 输出：["apple","google","leetcode"]
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"] 输出：["facebook","google"]
 *
 * 1 <= A.length, B.length <= 10000  1 <= A[i].length, B[i].length <= 10  A[i] 和 B[i] 只由小写字母组成 A[i]中所有的单词都是独一无二的，也就是说不存在 i != j 使得 A[i] == A[j]
 *
 * 思路：正常思路肯定超时，n^3的写法，主要是变化这个通用单词的解法，当我们检验 "warrior" 是否是 B = ["wrr", "wa", "or"] 的超集时，我们以按照字母出现的最多次数将 B 中所有单词合并成一个单词 "arrow"，然后判断一次即可。
 *
 */
public class WordSubsets {

  private int[] a = new int[26];
  private int[] b = new int[26];

  public static void main(String[] args) {

    String A[] = {"amazon","apple","facebook","google","leetcode"};
    String B[] = {"e","o"};

    new WordSubsets().wordSubsets(A, B);


  }

  public List<String> wordSubsets(String[] A, String[] B) {

    /**
     * 正常解法会超时
     */
//    List<String> result = new LinkedList<>();
//    for (int i = 0; i < A.length; i++) {
//      boolean canAdd = true;
//      for (int j = 0; j < B.length; j++) {
//        if (!isSubString(A[i], B[j])) {
//          canAdd = false;
//          break;
//        }
//      }
//      if (canAdd) result.add(A[i]);
//    }
//    return result;

    //就是拼成B的新单词，节省不少步骤，不用每个单词，每个单词去做了，合体
    int []bmax = count("");
    for (String b : B) {
      int[] bCount = count(b);
      for (int i = 0; i < 26; i++) {
        bmax[i] = Math.max(bmax[i], bCount[i]);
      }
    }
    List<String> ans = new LinkedList<>();
    for (String a : A) {
      int[] aCount = count(a);
      boolean canAdd = true;
      for (int i = 0; i < 26; i++) {
        if (aCount[i] < bmax[i]) {
          canAdd = false;
          break;
        }
      }
      if (canAdd) ans.add(a);
    }

    return ans;
  }

  private int[] count(String S) {
    int ans[] = new int[26];
    for (char c : S.toCharArray()) {
      ans[c-'a']++;
    }
    return ans;
  }

  private boolean isSubString(String A, String B) {
    Arrays.fill(a,0);
    Arrays.fill(b,0);
    for (int i = 0; i < A.length(); i++) {
      a[A.charAt(i)-'a']++;
    }
    for (int i = 0; i < B.length(); i++) {
      b[B.charAt(i)-'a']++;
    }
    for (int i = 0; i < b.length; i++) {
      if (b[i] != 0 && b[i] > a[i]) {
        return false;
      }
    }
    return true;
  }

}
