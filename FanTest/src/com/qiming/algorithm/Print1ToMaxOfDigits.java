package com.qiming.algorithm;

/**
 * 打印从1到最大的n位数
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1: 输入: n = 1 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 思路：其实是要考虑大数的，转成字符做，但LC的返回是int，那就是正常做了
 *
 */
public class Print1ToMaxOfDigits {

  public int[] printNumbers(int n) {

    //因为n为正整数，所以最小为10，也可以把10改为9，100改为99等
    int[] map = { 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000,
        100_000_000, 1_000_000_000, Integer.MAX_VALUE };
    int size = map[n-1];
    int[] ans = new int[size - 1];
    for (int i = 1; i < size; i++) {
      ans[i - 1] = i;
    }
    return ans;

  }

}
