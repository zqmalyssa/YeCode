package com.qiming.test.datastructureAndAlgorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

  public static int binarySearch(int s[], int low, int high, int key) {

    //注意这边一定是小于等于
    while (low <= high) {
      int mid = (low + high) / 2;
      if (s[mid] == key) {
        return mid;
      } else if (s[mid] > key) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String args[]) {
    int s[] = {2,4,16,18,19,25,30,52};
    System.out.println(binarySearch(s, 0, s.length-1, 19));
  }

}
