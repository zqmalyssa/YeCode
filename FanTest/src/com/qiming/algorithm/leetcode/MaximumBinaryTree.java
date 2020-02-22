package com.qiming.algorithm.leetcode;

/**
 * 最大二叉树
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：1.二叉树的根是数组中的最大元素 2.左子树是通过数组中最大值左边部分构造出的最大二叉树
 * 3.右子树是通过数组中最大值右边部分构造出的最大二叉树，通过给定的数组构建最大二叉树，并且输出这个树的根节点
 *
 * 思路，递归写吧，最明确
 */
public class MaximumBinaryTree {

  public static void main(String[] args) {

    int[] test = {3,2,1,6,0,5};
    int[] test1 = new int[0];
    System.out.println(test1.length);
  }

  /**
   * 这段可以优化，自己搞下吧
   * @param nums
   * @return
   */
  public TreeNodeMaximumBinaryTree constructMaximumBinaryTree(int[] nums) {
    if (nums.length == 0) {
      return null;
    }

    if (nums.length == 1) {
      return new TreeNodeMaximumBinaryTree(nums[0]);
    }

    int maxIndex = maxIndex(nums, 0, nums.length);
    TreeNodeMaximumBinaryTree root = new TreeNodeMaximumBinaryTree(nums[maxIndex]);
    int left[] = new int[maxIndex - 0];
    for (int i = 0; i < left.length; i++) {
      left[i] = nums[i];
    }
    int right[] = new int[nums.length - maxIndex - 1];
    for (int i = 0; i < right.length; i++) {
      right[i] = nums[maxIndex + i + 1];
    }
    root.left = constructMaximumBinaryTree(left);
    root.right = constructMaximumBinaryTree(right);
    return root;
  }

  private int maxIndex (int[] array, int low, int high) {
    int index = low;
    for (int i = low + 1; i < high; i++) {
      if (array[i] > array[index]) {
        index = i;
      }
    }
    return index;
  }

}

class TreeNodeMaximumBinaryTree {
  int val;
  TreeNodeMaximumBinaryTree left;
  TreeNodeMaximumBinaryTree right;
  TreeNodeMaximumBinaryTree(int x) { val = x; }
}