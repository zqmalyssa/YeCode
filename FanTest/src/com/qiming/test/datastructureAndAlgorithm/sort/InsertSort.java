package com.qiming.test.datastructureAndAlgorithm.sort;

/**
 * 直接插入排序
 * 思想就是仅有一个元素的序列总是有序的，因此，可从第二个元素开始，直到第n个元素，逐个向有序序列中执行插入操作
 * 从而得到n个元素按关键字有序的序列
 *
 * 直接插入排序是稳定的算法
 */
public class InsertSort {

  public static void main(String[] args) {
    int[] s = {4,8,9,5,2,1,4,6};
    new InsertSort().insertSort(s, 0, 7);
    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }
  }

  public void insertSort(int[] a, int low, int high) {

    for (int i = low + 1; i <= high; i++) {
      if (a[i] < a[i-1]) {
        //小于时，需要将a[i]插入有序表
        int temp = a[i];
        a[i] = a[i-1];
        int j = i-2;
        //可以是如下这种写法
        for (; j >= low && temp < a[j]; j--) {
          a[j+1] = a[j]; //记录后移
        }
        a[j+1] = temp;
      }
    }

  }

}
