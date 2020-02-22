package com.qiming.algorithm.leetcode;

/**
 * K 次取反后最大化的数组和
 *
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 * 示例 1：输入：A = [4,2,3], K = 1 输出：5 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：输入：A = [3,-1,0,2], K = 3 输出：6 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 *
 *
 * 思路：辅助数组，套路的，主要是要发现最小值和进行取反要想清楚
 *
 */
public class MaximizeSumOfArrayAfterKNegations {

  public int largestSumAfterKNegations(int[] A, int K) {

    int[] number = new int[201]; //-100到100的所有数

    for (int t : A) {
      number[t + 100]++;
    }
    int i = 0;
    while (K > 0) {
      while (number[i] == 0) {
        i++;
      }
      number[i]--;
      number[200-i]++; //相反个数+1
      if (i > 100) { //若原最小数索引>100,则新的最小数索引应为200-i.(索引即number[]数组的下标)
        i = 200 - i;
      }
      K--;
    }

    int sum = 0;
    for (int j = i; j < number.length; j++) {
      sum += (j-100)*number[j]; //j-100是数字大小
    }

    return sum;
  }

}
