package com.qiming.algorithm.leetcode;

/**
 * 分割数组
 *
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 * 1、left 中的每个元素都小于或等于 right 中的每个元素。2、left 和 right 都是非空的。3、left 要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 *
 * 输入：[1,1,1,0,6,12] 输出：4 解释：left = [1,1,1,0]，right = [6,12] 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 *
 * 思路，自己的想法，效果不是太好，就是左边最大值和右边最小值，不停更新，直到leftMax <= rightMin
 *
 * 比较好解法在思路上是一样的，但是，用到了两个辅助数组，分别记录在某个位置上该有的最大值和最小值，再进行比较，但是好像效果也不怎么样。。
 */
public class PartitionArrayIntoDisjointIntervals {

  public static void main(String[] args) {
    int test1[] = {5,0,3,8,6};
    int test2[] = {1,1,1,0,6,12};
    System.out.println(new PartitionArrayIntoDisjointIntervals().partitionDisjoint(test2));
  }

  public int partitionDisjoint(int[] A) {
    /**
     * 自己的思路
     */
    //    if (A.length == 2) {
//      return 1;
//    }
//    int leftMax = A[0];
//    //找right的最小值
//    int rightMin = 1_000_000;
//    for (int i = 1; i < A.length; i++) {
//      if (A[i] < rightMin) {
//        rightMin = A[i];
//      }
//    }
//    for (int i = 0; i < A.length; i++) {
//      if (leftMax <= rightMin) {
//        return i + 1;
//      }
//      leftMax = Math.max(leftMax, A[i+1]);
//      if (A[i+1] == rightMin) {
//        //需要处理一下了，可能有重复值，判断是不是还是rightMin了
//        int newRightMin = A[i+2];
//        for (int j = i + 3; j < A.length; j++) {
//          if (A[j] < newRightMin) {
//            newRightMin = A[j];
//          }
//        }
//        rightMin = newRightMin == rightMin ? rightMin : newRightMin;
//      }
//      //否则rightMin不懂
//    }
//    return -1;

    /**
     * 辅助数组的思路
     */
    int N = A.length;
    int[] maxleft = new int[N];
    int[] minright = new int[N];

    int m = A[0];
    for (int i = 0; i < N; ++i) {
      m = Math.max(m, A[i]);
      maxleft[i] = m;
    }

    m = A[N-1];
    for (int i = N-1; i >= 0; --i) {
      m = Math.min(m, A[i]);
      minright[i] = m;
    }

    for (int i = 1; i < N; ++i)
      if (maxleft[i-1] <= minright[i])
        return i;

    return -1;
  }

}
