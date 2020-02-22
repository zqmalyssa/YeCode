package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合总数
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。说明，所有数字（包括 target）都是正整数。解集不能包含重复的组合。
 *
 * 思路是用回溯法，回溯法有模板可套，这边有一点小变化，需要有个标志位去从头开始遍历
 */
public class CombinedTotal {

  //自己可以这样写，如果是LC上，需要把这个变量变成局部变量
  private static List<List<Integer>> result = new LinkedList<>();

  public static void main(String[] args) {
    LinkedList<Integer> track =  new LinkedList<>();
    int nums[] = {2,3,5,6};
    backtrack(nums, track, 11, 0);

//    int nums[] = {2,3,6,7};
//    backtrack(nums, track, 7, 0);
    for (List<Integer> integers : result) {
      for (Integer integer : integers) {
        System.out.print(integer + " ");
      }
      System.out.println("\n");
    }
  }

  private static void backtrack(int nums[], LinkedList<Integer> track, int target, int begin) {
    int res = 0;
    if (track.size() != 0) {
      //可以lambda表达式写
      res = track.stream().reduce(Integer::sum).get();
    }
//    for (int i = 0; i < track.size(); i++) {
//      res += track.get(i);
//    }

    if (res == target) {
      //如果和等于target了，结束
      result.add(new LinkedList<>(track));
      return;
    }

    for (int i = begin; i < nums.length; i++) {
      //加入之前要排除不合法的选择，这边一定要想清楚，不然会死循环
      if (res + nums[i] > target) {
        continue;
      }
      track.add(nums[i]);
      //这个i是关键，去除重复的解
      backtrack(nums, track, target, i);
      track.removeLast();
    }

  }

}
