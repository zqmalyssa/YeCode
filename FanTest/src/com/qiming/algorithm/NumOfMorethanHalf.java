package com.qiming.algorithm;

/**
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一般，请找出这个数字，例如。输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2
 *
 *
 * 思路，基于partition函数的O(n)算法，因为排序之后，数组中间的数字一定就是那个出现次数超过数组长度一半的数字了，递归去做
 *
 * 还有个想法就有点吊了，数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现的次数的和还要多，因为我们可以考虑在遍历数组的时候保存两个值
 * 一个是数组中的数字，一个是次数，当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1，如果下一个数字和我们之前保存的数字不同，则次数减1。
 * 如果次数为零，我们需要保存下一个数字，并把次数设为1。关键来了，由于数字的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字
 *
 */
public class NumOfMorethanHalf {

  public static void main(String[] args) {

    int a[] = {1,2,3,2,2,2,5,4,2};
    System.out.println(new NumOfMorethanHalf().MoreThanHalfNum(a));

  }

  public int MoreThanHalfNum(int number[]) {

    if (number.length == 0) {
      return 0;
    }

    int len = number.length;
    int middle = len >> 1;
    int start = 0;
    int end = len-1;
    int index = partition(number, start, end);
    while (index != middle) {
      if (index > middle) {
        end = index - 1;
        index = partition(number, start, end);
      } else {
        start = index + 1;
        index = partition(number, start, end);
      }
    }

    return number[middle];
    /**
     * 第二种方法
     */
//    int result = number[0];
//    int times = 1;
//    for (int i = 0; i < number.length; i++) {
//      if (times == 0) {
//        result = number[i];
//        times = 1;
//      } else if (number[i] == result) {
//        times++;
//      } else {
//        times--;
//      }
//    }
//    return result;

  }

  private int partition(int a[], int low, int high) {

    int pivot = a[low];
    while (low < high) {
      while (low < high && a[high] >= pivot) {
        high--;
      }
      a[low] = a[high];
      while (low < high && a[low] <= pivot) {
        low++;
      }
      a[high] = a[low];
    }
    a[low] = pivot;
    return low;
  }

}
