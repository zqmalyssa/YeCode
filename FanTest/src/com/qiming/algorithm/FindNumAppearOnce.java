package com.qiming.algorithm;

import java.io.Serializable;

/**
 * 数组中只出现一次的数字
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]  输出：[2,10] 或 [10,2]  2 <= nums <= 10000
 *
 * 思路：运用性质，自己的数字异或后结果为0，如果只有一个数字是1次，那么数组所有数字异或完后就剩下这个1次的数字了，那问题是两个，就要把原数组分成两个子数组
 * 怎么分，还是将原数组所有的元素都异或一遍，结果肯定不为0，也就是二进制中有1的位置，至少，找到第一个为1的位置，记为第n位，现在我们就以第n位是不是1为标准
 * 把原数组分成两个子数组，第一个子数组中每个数字的第n位都是1，第二个子数组中每个数字的第n位都是0，那么出现两次的数字肯定被分配到一个子数组？？因为相同必须每位都同
 *
 *
 */
public class FindNumAppearOnce {

  public int[] singleNumbers(int[] nums) {

    int result[] = {0, 0};
    int resultExclusiveOR = 0;
    for (int i = 0; i < nums.length; i++) {
      resultExclusiveOR ^= nums[i];
    }
    int index = findFirstOne(resultExclusiveOR);

    for (int i = 0; i < nums.length; i++) {
      //为1的
      if (isBit1(nums[i], index)) {
        result[0] ^= nums[i];
      } else {
        result[1] ^= nums[i];
      }
    }

    return result;
  }

  private int findFirstOne(int num) {

    int index = 0;
    while ((num & 1) == 0) {
      num = num >> 1;
      index++;
    }
    return index;

  }

  private boolean isBit1(int num, int index) {
    num = num >> index;
    return (num & 1) == 1;
  }

}
