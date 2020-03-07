package com.qiming.algorithm;

/**
 * 构建乘积数组
 *
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例: 输入: [1,2,3,4,5] 输出: [120,60,40,30,24]
 * 提示：所有元素乘积之和不会溢出 32 位整数 a.length <= 100000
 *
 * 思路：使用左右数组来进行存储，L[i]存储a[i]左边的乘积，R[i]存储a[i]右边的乘积，空间换时间的做法，最后有三次遍历
 *
 */
public class BuildProductArray {

  public int[] constructArr(int[] a) {

    if (a.length == 0) {
      return new int[0];
    }

    int L[] = new int[a.length];
    int R[] = new int[a.length];
    L[0] = 1;
    R[R.length - 1] = 1;

    for (int i = 1; i < L.length; i++) {
      L[i] = L[i-1] * a[i-1];
    }

    for (int i = R.length - 2; i >= 0; i--) {
      R[i] = R[i+1] * a[i+1];
    }

    for (int i = 0; i < L.length; i++) {
      L[i] = L[i] * R[i];
    }

    return L;

  }

}
