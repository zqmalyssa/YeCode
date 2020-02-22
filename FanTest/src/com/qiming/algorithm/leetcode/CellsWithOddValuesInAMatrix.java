package com.qiming.algorithm.leetcode;

/**
 * 奇数值单元格的数目
 *
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 *
 * 提示：1 <= n <= 50 1 <= m <= 50 1 <= indices.length <= 100  0 <= indices[i][0] < n  0 <= indices[i][1] < m
 *
 * 思路：画几个图就知道了，顺序不重要，最后是奇数就行了，挖掉横竖相交的部分，不要忘了乘以2，重合了两次
 *
 */
public class CellsWithOddValuesInAMatrix {

  public static void main(String[] args) {
    int n = 2;
    int m = 2;
    int[][] indices = {{1,1},{0,0}};
    System.out.println(new CellsWithOddValuesInAMatrix().oddCells(n,m,indices));
  }

  public int oddCells(int n, int m, int[][] indices) {

    int row[] = new int[50];
    int column[] = new int[50];

    for (int i = 0; i < indices.length; i++) {
      row[indices[i][0]]++;
      column[indices[i][1]]++;
    }
    int rowOdd = 0;
    int columnOdd = 0;
    for (int i = 0; i < row.length; i++) {
      if (row[i] % 2 == 1) {
        rowOdd++;
      }
      if (column[i] % 2 == 1) {
        columnOdd++;
      }
    }

    return rowOdd * m + columnOdd * n - rowOdd * columnOdd *2;

  }

}
