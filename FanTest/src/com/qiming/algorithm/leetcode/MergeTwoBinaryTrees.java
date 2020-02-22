package com.qiming.algorithm.leetcode;

/**
 * 合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
 * 那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 思路：递归，清晰一点，迭代需要用到辅助栈
 *
 */
public class MergeTwoBinaryTrees {

  public TreeNodeMergeTwoBinaryTrees mergeTrees(TreeNodeMergeTwoBinaryTrees t1, TreeNodeMergeTwoBinaryTrees t2) {

    if (t1 == null) {
      return t2;
    }

    if (t2 == null) {
      return t1;
    }
    //这边也可以不new，直接用t1
    TreeNodeMergeTwoBinaryTrees root = new TreeNodeMergeTwoBinaryTrees(t1.val + t2.val);
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t1.right, t2.right);

    return root;

  }

}

class TreeNodeMergeTwoBinaryTrees {

  int val;
  TreeNodeMergeTwoBinaryTrees left;
  TreeNodeMergeTwoBinaryTrees right;
  TreeNodeMergeTwoBinaryTrees(int x) { val = x;}

}
