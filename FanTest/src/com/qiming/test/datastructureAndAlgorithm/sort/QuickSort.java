package com.qiming.test.datastructureAndAlgorithm.sort;

/**
 * 快速排序要写个辅助的partition
 */

public class QuickSort {

  private int partition(int s[], int low, int high) {
    int pivot = s[low];
    while (low < high) {
      while (low < high && s[high] >= pivot) {
        high --;
      }
      s[low] = s[high];
      while (low < high && s[low] <= pivot) {
        low ++;
      }
      s[high] = s[low];
    }
    //pivot要被填到坑里面
    s[low] = pivot;
    return low;
  }

  public void quickSort(int s[], int low, int high) {
    if (low < high) {
      int pa = partition(s, low, high);
      quickSort(s, low, pa-1);
      quickSort(s, pa+1, high);
    }
  }

  public static void main(String args[]) {
    int s[] = {3,78,23,16,73,10,7,43};
    new QuickSort().quickSort(s, 0, s.length-1);
    for (int num : s) {
      System.out.println(num);
    }
  }

}
