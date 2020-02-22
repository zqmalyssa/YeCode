package com.qiming.algorithm.leetcode;

/**
 * 给定一个二叉树，将其展开成链表（都是右子树）
 * 找规律。将当前节点的右子树放到左子树的最右边的节点上
 */
public class BinTreeToList {

  public void flatten(TreeNode root) {
    for (TreeNode p = root; p != null; p=p.right) {
      if (p.left == null) {
        continue;
      }
      TreeNode most_right = p.left;
      while (most_right.right != null) {
        most_right = most_right.right;
      }
      most_right.right = p.right;
      p.right = p.left;
      p.left = null;
    }
  }

}
