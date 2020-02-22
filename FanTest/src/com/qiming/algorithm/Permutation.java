package com.qiming.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列的代码
 *
 * 使用到了回溯法
 */
public class Permutation {

  private static List<List<Integer>> res = new LinkedList<>();

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    permute(nums);
    for (List<Integer> re : res) {
      for (Integer integer : re) {
        System.out.print(integer + " ");
      }
      System.out.println("\n");
    }
  }

  private static List<List<Integer>> permute(int nums[]) {
    //记录[路径]
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return res;
  }

  /**
   * 核心的递归，
   * 路径：记录在 track 中
   * 选择列表：nums 中不存在于 track 的那些元素
   * 结束条件：nums 中的元素全都在 track 中出现
   * @param nums
   * @param track
   */
  private static void backtrack(int[] nums, LinkedList<Integer> track) {
    // 触发结束条件
    if (track.size() == nums.length) {
      //这种方法是进行拷贝吧？
      res.add(new LinkedList(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // 排除不合法的选择
      if (track.contains(nums[i]))
        continue;
      // 做选择
      track.add(nums[i]);
      // 进入下一层决策树
      backtrack(nums, track);
      // 取消选择
      track.removeLast();
    }
  }

}
