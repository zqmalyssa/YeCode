package com.qiming.algorithm;

/**
 * 丑数
 *
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例: 输入: n = 10  输出: 12 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 说明:  1 是丑数。 n 不超过1690。
 *
 * 思路：写一个判断丑数的方法，再每个元素比较，但是常规都不是套路
 *
 * 不要在非丑数身上浪费时间，丑数是另一个丑数乘以2、3或者5的结果。因此我们可以创建一个数组，里面的数字是排序好的丑数。这个思路关键在于怎么确保数组里是排序好的
 *
 * 丑数肯定是前面一个数乘以2或3或5的结果，如果现在数组里的最大是M，那么先把所有数乘以2，得到的序列肯定有比M大的，记第一个比M大的数为M2。然后3或5是同样的，记为M3
 * 和M5，所以下一个丑数是M2，M3，M5的较小者，但都乘又不科学，因为已有的丑数是按序排列的，对乘2而言，肯定存在某一个丑数T2，排在它走之前的每一个丑数乘以2得到的结果
 * 都会小于已有最大的丑数，在它之后的结果都会太大，我们只需要记下这个丑数的位置，同时每次生成新的丑数的时候，去更新这个T2，T3和T5一样。同LC264
 *
 */
public class UglyNumber {

  public int nthUglyNumber(int n) {

    /**
     * 正常遍历的解法
     */
//    if (n <= 0) {
//      return 0;
//    }
//
//    int number = 0;
//    int found = 0;
//    while (found < n) {
//      number++;
//      if (isUglyNumber(number)) {
//        found++;
//      }
//    }
//
//    return number;

    //注意n不超过1690，用辅助数组的思路，记录排序好的数组
    if (n <= 0) {
      return 0;
    }
    int result[] = new int[n];
    result[0] = 1;
    int nextUglyIndex = 1;
    int pMultiply2 = 0;
    int pMultiply3 = 0;
    int pMultiply5 = 0;

    while (nextUglyIndex < n) {
      //记得是索引值和相应数值的乘
      int min = ThreeNumMin(result[pMultiply2] * 2, result[pMultiply3] * 3, result[pMultiply5] * 5);
      result[nextUglyIndex] = min;
      //
      while (result[pMultiply2] * 2 <= result[nextUglyIndex]) {
        pMultiply2++;
      }
      while (result[pMultiply3] * 3 <= result[nextUglyIndex]) {
        pMultiply3++;
      }
      while (result[pMultiply5] * 5 <= result[nextUglyIndex]) {
        pMultiply5++;
      }
      nextUglyIndex++;
    }

    return result[nextUglyIndex-1];
  }

  private int ThreeNumMin (int num1, int num2, int num3) {
    int minfirst = Math.min(num1, num2);
    return Math.min(minfirst, num3);
  }


  //判断丑数的方法
  private boolean isUglyNumber(int n) {

    while (n % 2 == 0) {
      n = n / 2;
    }
    while (n % 3 == 0) {
      n = n / 3;
    }
    while (n % 5 == 0) {
      n = n / 5;
    }
    return (n == 1) ? true : false;
  }

}
