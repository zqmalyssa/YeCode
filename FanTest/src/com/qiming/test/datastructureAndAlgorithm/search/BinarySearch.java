package com.qiming.test.datastructureAndAlgorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

  /**
   * 非递归写法
   * @param s
   * @param low
   * @param high
   * @param key
   * @return
   */
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


  /**
   * 递归写法
   * @param s
   * @param low
   * @param high
   * @param key
   * @return
   */
  public static int binarySearchRecursion(int s[], int low, int high, int key) {

    if (low > high) {
      return -1;
    }

    int mid = (low + high) / 2;
    if (key == s[mid]) {
      return mid;
    } else if (key < s[mid]) {
      return binarySearchRecursion(s, low, mid - 1, key);
    } else {
      return binarySearchRecursion(s, mid + 1, high, key);
    }

  }
  public static void main(String args[]) {
    int s[] = {2,4,16,18,19,25,30,52};
    System.out.println(binarySearch(s, 0, s.length-1, 19));
  }

}
