package com.qiming.algorithm.leetcode;


import java.util.Stack;

/**
 * 下一个更大元素 II
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 思路，一个解法是正常思维解法
 * 还有一个解法是单调栈，
 * 我们首先把第一个元素 A[1] 放入栈，随后对于第二个元素 A[2]，如果 A[2] > A[1]，那么我们就找到了 A[1] 的下一个更大元素 A[2]，此时就可以把 A[1] 出栈并把 A[2] 入栈；
 * 如果 A[2] <= A[1]，我们就仅把 A[2] 入栈。对于第三个元素 A[3]，此时栈中有若干个元素，那么所有比 A[3] 小的元素都找到了下一个更大元素（即 A[3]），
 * 因此可以出栈，在这之后，我们将 A[3] 入栈，以此类推。可以发现，我们维护了一个单调栈，栈中的元素从栈顶到栈底是单调不降的。当我们遇到一个新的元素 A[i] 时，我们判断栈顶元素是否小于 A[i]，如果是，那么栈顶元素的下一个更大元素即为 A[i]
 * 我们将栈顶元素出栈。重复这一操作，直到栈为空或者栈顶元素大于 A[i]。此时我们将 A[i] 入栈，保持栈的单调性，并对接下来的 A[i + 1], A[i + 2] ... 执行同样的操作。
 *
 * 由于这道题的数组是循环数组，因此我们需要将每个元素都入栈两次。这样可能会有元素出栈找过一次，即得到了超过一个“下一个更大元素”，我们只需要保留第一个出栈的结果即可。
 */
public class NextGreaterElementII {

  public static void main(String[] args) {
    int test1[] = {1,2,1};
    int test2[] = {1,5,3,6,8};
    int result[] = new NextGreaterElementII().nextGreaterElements(test2);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  public int[] nextGreaterElements(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = findNum(nums, i, nums[i]);
    }
    return result;

    /**
     * 单调栈方法如下
     */
//    int[] res = new int[nums.length];
//    Stack<Integer> stack = new Stack<>();
//    for (int i = 2 * nums.length - 1; i >= 0; --i) {
//      while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
//        stack.pop();
//      }
//      res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
//      stack.push(i % nums.length);
//    }
//    return res;

  }

  private int findNum(int[] array, int num, int value) {
    int result = -1;

    if (num == 0) {
      for (int i = 1; i < array.length; i++) {
        if (array[i] > value) {
          return array[i];
        }
      }
    } else if (num == array.length - 1) {
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > value) {
          return array[i];
        }
      }
    } else {
      //前后都要
      for (int i = num + 1; i < array.length; i++) {
        if (array[i] > value) {
          return array[i];
        }
      }
      for (int i = 0; i < num; i++) {
        if (array[i] > value) {
          return array[i];
        }
      }

    }

    return result;
  }

}
