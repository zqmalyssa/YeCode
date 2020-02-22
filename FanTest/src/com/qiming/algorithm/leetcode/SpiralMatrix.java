package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 思路 就是生转，这边主要是建立该什么时候转跟怎么转
 *
 */
public class SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    List ans = new LinkedList();
    if (matrix.length == 0) return ans;
    int R = matrix.length, C = matrix[0].length;
    boolean[][] seen = new boolean[R][C];
    //下面两个其实定义死了方向，两个数组的0标意思是向右，1标意思是向下，2标是向走，3标识向上
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int r = 0, c = 0, di = 0;
    for (int i = 0; i < R * C; i++) {
      ans.add(matrix[r][c]);
      seen[r][c] = true;
      int cr = r + dr[di];
      int cc = c + dc[di];
      //不符合就顺时针转，条件如下
      if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
        r = cr;
        c = cc;
      } else {
        //用mod转
        di = (di + 1) % 4;
        r += dr[di];
        c += dc[di];
      }
    }
    return ans;

  }

}
