package com.qiming.algorithm;

/**
 * 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：找由上角的数字，根据递增的特性，不断缩写行和列
 *
 */
public class FindNumberIn2DArray {

  public static void main(String[] args) {

  }

  public boolean findNumberIn2DArray(int[][] matrix, int target) {

    boolean found = false;

    if (matrix.length > 0 && matrix[0].length > 0) {
      int row = 0;
      int column = matrix[0].length - 1;
      while (row < matrix.length && column >= 0) {
        if (matrix[row][column] == target) {
          found = true;
          break;
        } else if (matrix[row][column] > target) {
          column--;
        } else {
          row++;
        }
      }
    }

    return found;

  }

}
