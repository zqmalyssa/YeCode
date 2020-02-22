package com.qiming.algorithm;

/**
 * 求一个int数组的中位数，中位数是有序的中位数
 * 方法是稍微改造下快排的partition
 */

public class MediumFind {

  public static void main(String args[]) {
//    int[] num1 = {18,14,20,40,11,8,5};
//    int[] num2 = {18,14,20,40,11,8,5,51};
    int[] num1 = {17,15,24,14,3,12,1};
    int[] num2 = {18,14,20,40,11,8,5,51,2,45,21,39,31,16};
    int medium1 = partition(num1, 0, num1.length - 1);
    int medium2 = partition(num2, 0, num2.length - 1);
    System.out.println(medium1);
    System.out.println(medium2);
  }

  //改造一下partition方法
  private static int partition(int s[], int low, int high) {
    //需要加两个变量
    int start = low;
    int end = high;

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
//    return low;

    //以下是定位部分
    if (low == (s.length -1 )/2) {
      return s[low];
    } else if (low > (s.length -1 )/2) {
      return partition(s, start, low-1);
    } else {
      return partition(s, low + 1, end);
    }

  }

}
