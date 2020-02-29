package com.qiming.algorithm;

/**
 * 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：最右边的值肯定是根结点了，那么前面的元素，有一部分是左子树的，值小于根结点，有一部分是右子树，值大于根结点，递归的看都是这样，不能违背二叉搜索树的定义
 *
 */
public class VerifyPostOrder {

  public boolean verifyPostorder(int[] postorder) {

    return helper(postorder, 0, postorder.length-1);

  }

  private boolean helper(int nums[], int start, int end) {
    if (nums.length == 0) {
      return true;
    }

    int root = nums[end];

    int i = start;
    for (; i < end; i++) {
      if (nums[i] > root) {
        break;
      }
    }

    int j = i;
    for (; j < end; j++) {
      if (nums[j] < root) {
        return false;
      }
    }

    boolean leftTree = true;
    if (i > start) {
      leftTree = helper(nums, start, i - 1);
    }
    boolean rightTree = true;
    if (i < end - 1) {
      rightTree = helper(nums, i, end - 1);
    }

    return leftTree && rightTree;
  }

}
