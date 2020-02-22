package com.qiming.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 删除被覆盖的区间
 *
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 * 思路是排序 + 遍历
 * 如果我们将所有区间按照左端点递增排序，那么对于排完序的列表中第i个区间(li, ri);
 * 在i之前的区间j，一定满足lj < li，因此只要存在rj > ri，那么i这个区间一定会被覆盖，也就是之前区间的右端点最大值rmax满足>=ri，i就能被覆盖
 * 那么之后的区间呢，对于k，只有lk > li，因此一定不会被后面的区间覆盖，但是如果lk = li呢，还是有可能的，所以将右端点递减，这样即使出现相同的情况，也不会有问题
 */
public class RemoveCoveredIntervals {

  public static void main(String[] args) {
    int a[] = {3,1,2,6};
    int b[][] = {{5,2},{4,3},{2,5},{2,4},{4,6}};
//    Arrays.sort(b);
//    for (int i = 0; i < b.length; i++) {
//      System.out.println(b[i]);
//    }
    new RemoveCoveredIntervals().removeCoveredIntervals(b);
    for (int i = 0; i <b.length; i++) {
      for (int j = 0; j < b[i].length; j++) {
        System.out.println(b[i][j]);
      }
    }
  }

  public int removeCoveredIntervals(int[][] intervals) {
    //java的二维数组升序降序方法
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
      }
    });
    int result = intervals.length;
    int rmax = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][1] <= rmax) {
        result--;
      } else {
        rmax = Math.max(rmax, intervals[i][1]);
      }
    }
    return result;
  }

  private void sort(int[][] array) {
    quickSortTwoArray(array, 0 , array.length - 1);
  }

  private int partition(int s[][], int low, int high) {
    int pivot = s[low][0];
    int twoValue = s[low][1];
    while (low < high) {
      while (low < high && s[high][0] >= pivot) {
        high --;
      }
      s[low][0] = s[high][0];
      s[low][1] = s[high][1];
      while (low < high && s[low][0] <= pivot) {
        low ++;
      }
      s[high][0] = s[low][0];
      s[high][1] = s[low][1];
    }
    //pivot要被填到坑里面
    s[low][0] = pivot;
    s[low][1] = twoValue;
    return low;
  }

  public void quickSortTwoArray(int s[][], int low, int high) {
    if (low < high) {
      int pa = partition(s, low, high);
      quickSortTwoArray(s, low, pa-1);
      quickSortTwoArray(s, pa+1, high);
    }
  }

}
