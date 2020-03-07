package com.qiming.algorithm;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1: 输入: [1,2,3,4,5] 输出: True 示例 2: 输入: [0,0,1,2,5] 输出: True  数组长度为 5  数组的数取值为 [0, 13] .
 *
 * 思路：先排序，排完序后统计0的个数，统计相邻数字之间的空缺总数，如果空缺的总数小于或者等于0的个数，那么就是连续的，还有，非0的数字是不能出现重复的，不满足顺子的要求
 *
 */
public class IsContinuous {

  public boolean isStraight(int[] nums) {
    Arrays.sort(nums);
    int numberOfZero = 0;
    int numberOfGap = 0;

    //统计数组中0的个数
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        numberOfZero++;
      }
    }

    //统计数组中的间隔数目
    int small = numberOfZero;
    int big = small + 1;
    while (big < nums.length) {
      //两个数相等，有对子，不可能是数字
      if (nums[small] == nums[big]) {
        return false;
      }

      numberOfGap += nums[big] - nums[small] - 1;
      small = big;
      big++;

    }
    return (numberOfGap > numberOfZero) ? false : true;
  }

}
