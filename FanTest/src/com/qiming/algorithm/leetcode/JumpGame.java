package com.qiming.algorithm.leetcode;

/**
 * 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1: 输入: [2,3,1,1,4] 输出: true 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 输入: [3,2,1,0,4] 输入: [3,2,1,0,4] 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 思路：动态规划，这个可以在数据结构和算法中看看
 *
 */
public class JumpGame {

  public static void main(String[] args) {

    int test[] = {2,3,1,1,4};
    new JumpGame().canJump(test);
  }


  //还是得用贪心或者动态规划
  public boolean canJump(int[] nums) {
//    if (nums.length == 1) {
//      return true;
//    }
//    return helper(nums, 0, nums.length);
    int lastPos = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= lastPos) {
        lastPos = i;
      }
    }
    return lastPos == 0;
  }

/**
 * 错误案例
 */
//  public boolean canJump(int[] nums) {
//    if (nums.length == 1) {
//      return true;
//    }
//    return helper(nums, 0, nums.length);
//  }
//
//  private boolean helper (int[] nums, int start, int limit) {
//    for (int i = start; i < nums.length - 1; i++) {
//      //代表会有问题，迭代去检查，这样写会有问题[3,0,8,2,0,0,1]就过不鸟
//      if (nums[i] == 0) {
//        return false;
//      }
//      if (nums[i] < limit - 1) {
//        boolean result = helper(nums, start + 1, limit - 1);
//        if (result) {
//          return true;
//        }
//      } else {
//        return true;
//      }
//    }
//    return false;
//  }

}
