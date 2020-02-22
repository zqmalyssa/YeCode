package com.qiming.algorithm.leetcode;

/**
 * 删列造序
 *
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符
 *
 * 形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。比如，有 A = ["abcdef", "uvwxyz"]， 要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
 *
 * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
 *
 *
 * 思路，正常思路，暴力去保持每一列都符合，不符合就++
 *
 */
public class DeleteColumnsToMakeSorted {

  public int minDeletionSize(String[] A) {

    int columnLen = A.length;
    int wordLen = A[0].length();
    int deleted = 0;
    for (int i = 0; i < wordLen; i++) {
      Character pre = null;
      for (int j = 0; j < columnLen; j++) {
        if (pre != null) {
          if (A[j].charAt(i) - A[j-1].charAt(i) < 0) {
            deleted++;
            break;
          }
        }
        pre = A[j].charAt(i);
      }
    }
    return deleted;
  }

}
