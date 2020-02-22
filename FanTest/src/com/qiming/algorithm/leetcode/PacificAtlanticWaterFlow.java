package com.qiming.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 太平洋大西洋水流问题
 *
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 * 输出坐标的顺序不重要，m 和 n 都小于150
 *
 * 思路 反向思维么，可以从最左边和最上面开始dfs所有可以到达的山脉，即为可以流向太平洋的山脉，从最右边和最下面开始dfs所有可以到达的山脉，即为可以流向大西洋的山脉
 * 注意：此时dfs的方向为从高度低的山脉向高度高的山脉走
 *
 */
public class PacificAtlanticWaterFlow {

  private boolean[][] pacific; // 可以流向太平洋的位置
  private boolean[][] atlantic; // 可以流向大西洋的位置
  private int row, col;

  public static void main(String[] args) {
    int test[][] = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
    List<List<Integer>> result = new PacificAtlanticWaterFlow().pacificAtlantic(test);
    for (List<Integer> list : result) {
      for (Integer integer : list) {
        System.out.print(integer + " ");
      }
      System.out.println("\n");
    }
  }

  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    List<List<Integer>> res = new LinkedList<>();
    if (matrix == null || matrix.length == 0)
      return new LinkedList<>();
    row = matrix.length;
    col = matrix[0].length;

    pacific = new boolean[row][col];
    atlantic = new boolean[row][col];

    //横边的DFS遍历
    for (int i = 0; i < row; i++) {
      dfs(matrix, pacific, i, 0);
      dfs(matrix, atlantic, i, col - 1);
    }

    //竖边的DFS遍历
    for (int i = 0; i < col; i++) {
      dfs(matrix, pacific, 0, i);
      dfs(matrix, atlantic, row - 1, i);
    }

    //与为1的就是ok的
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          LinkedList<Integer> list = new LinkedList();
          list.add(i);
          list.add(j);
          res.add(list);
        }
      }
    }
    return res;
  }

  private void dfs(int[][] matrix, boolean[][] map, int i, int j) {
    if (i < 0 || i >= row || j < 0 || j >= col || map[i][j])
      return;
    map[i][j] = true;
    //上下左右四种情况，从低到高走
    if (i - 1 >= 0 && matrix[i][j] <= matrix[i - 1][j])
      dfs(matrix, map, i - 1, j);
    if (j - 1 >= 0 && matrix[i][j] <= matrix[i][j - 1])
      dfs(matrix, map, i, j - 1);
    if (i + 1 < row && matrix[i][j] <= matrix[i + 1][j])
      dfs(matrix, map, i + 1, j);
    if (j + 1 < col && matrix[i][j] <= matrix[i][j + 1])
      dfs(matrix, map, i, j + 1);
  }

}
