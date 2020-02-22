package com.qiming.algorithm.leetcode;

/**
 * 二叉搜索树中的搜索
 */
public class BinTreeSearch {

  public static void main(String[] args) {

    TreeNode t1 = new TreeNode(4);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(7);
    TreeNode t4 = new TreeNode(1);
    TreeNode t5 = new TreeNode(3);
    t1.left = t2;
    t1.right = t3;
    t2.left = t4;
    t2.right = t5;

    TreeNode result = new BinTreeSearch().searchBST(t1, 2);

    System.out.println(result.val);
  }

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    } else if (root.val > val){
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }

}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}