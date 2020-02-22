package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。说明：解集不能包含重复的子集。
 *
 * 输入: nums = [1,2,3]  输出: [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 *
 * 思路：回溯算法，模板解，无终止条件
 *
 */
public class Subsets {

  private List<List<Integer>> res = new LinkedList<>();

  public static void main(String[] args) {
    int nums[] = new int[3];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i + 1;
    }
    List<List<Integer>> result = new Subsets().subsets(nums);
    for (List<Integer> integers : result) {
      for (Integer integer : integers) {
        System.out.print(integer + " ");
      }
      System.out.println("\n");
    }
  }

  public List<List<Integer>> subsets(int[] nums) {

    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track, 0);
    return res;
  }

  private void backtrack(int nums[], LinkedList<Integer> track, int begin) {
    //这个题目就是没有终止条件，直接运行完就行，注意这个begin和new出来的track，否则res里面会出现很诡异的同值
    res.add(new LinkedList<>(track));
    for (int i = begin; i < nums.length; i++) {
      track.add(nums[i]);
      backtrack(nums, track, i + 1);
      //取消选择
      track.removeLast();
    }
  }

}
