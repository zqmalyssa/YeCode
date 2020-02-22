package com.qiming.test.datastructureAndAlgorithm.sort;

/**
 * 归并排序，分治思想
 * 与快速排序和堆排序对比，归并排序的优点是它是一个稳定的排序算法
 * 归并排序如果不使用递归，可以用自底而上的方式实现
 */

public class MergeSort {

  public static void main(String[] args) {
    int[] s = {4,8,9,5,2,1,4,6};
    new MergeSort().mergeSort(s, 0, 7);
    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }
  }

  public void mergeSort(int[] s, int low, int high) {
    if (low < high) {
      mergeSort(s, low, (low + high)/2);
      mergeSort(s, (low + high)/2 + 1, high);
      merge(s, low, (high + low)/2, high);
    }
  }

  /**
   * 分成两个区间，[p..q]和[q+1..r]
   * @param a
   * @param p
   * @param q
   * @param r
   */
  private void merge(int[] a, int p, int q, int r) {
    int[] b = new int[r-p+1];
    int s = p;
    int t = q + 1;
    int k = 0;
    while (s <= q && t <= r) {
      if (a[s] < a[t]) {
        b[k++] = a[s++];
      } else {
        b[k++] = a[t++];
      }
    }
    //补充前段
    while (s <= q) {
      b[k++] = a[s++];
    }
    //补充后段
    while (t <= r) {
      b[k++] = a[t++];
    }
    for (int i = 0; i < b.length; i++) {
      a[p+i] = b[i];
    }
  }

}
