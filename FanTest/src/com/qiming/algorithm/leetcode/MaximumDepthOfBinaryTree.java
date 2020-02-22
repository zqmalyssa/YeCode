package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 给定二叉树 [3,9,20,null,null,15,7]  返回它的最大深度 3 。
 *
 * 思路：层次遍历辅助队列
 *
 */
public class MaximumDepthOfBinaryTree {

  public static void main(String[] args) {
    TreeNodeMaximumDepthOfBinaryTree p1 = new TreeNodeMaximumDepthOfBinaryTree(0);
    TreeNodeMaximumDepthOfBinaryTree p2 = new TreeNodeMaximumDepthOfBinaryTree(2);
    TreeNodeMaximumDepthOfBinaryTree p3 = new TreeNodeMaximumDepthOfBinaryTree(4);
    TreeNodeMaximumDepthOfBinaryTree p4 = new TreeNodeMaximumDepthOfBinaryTree(1);
    TreeNodeMaximumDepthOfBinaryTree p5 = new TreeNodeMaximumDepthOfBinaryTree(3);
    TreeNodeMaximumDepthOfBinaryTree p6 = new TreeNodeMaximumDepthOfBinaryTree(-1);
    TreeNodeMaximumDepthOfBinaryTree p7 = new TreeNodeMaximumDepthOfBinaryTree(5);
    TreeNodeMaximumDepthOfBinaryTree p8 = new TreeNodeMaximumDepthOfBinaryTree(1);
    TreeNodeMaximumDepthOfBinaryTree p9 = new TreeNodeMaximumDepthOfBinaryTree(6);
    TreeNodeMaximumDepthOfBinaryTree p10 = new TreeNodeMaximumDepthOfBinaryTree(8);
    p1.left = p2;
    p1.right = p3;
    p2.left = p4;
    p3.left = p5;
    p3.right = p6;
    p4.left = p7;
    p4.right = p8;
    p5.right = p9;
    p6.right = p10;
    System.out.println(new MaximumDepthOfBinaryTree().maxDepth(p1));
  }

  public int maxDepth(TreeNodeMaximumDepthOfBinaryTree root) {

    if (root == null) {
      return 0;
    }
    Queue<TreeNodeMaximumDepthOfBinaryTree> queue = new LinkedList();
    queue.offer(root);
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size(); //细节细节
      for (int i = 0; i < size; i++) {
        TreeNodeMaximumDepthOfBinaryTree p = queue.poll();
        if (p.left != null) {
          queue.offer(p.left);
        }
        if (p.right != null) {
          queue.offer(p.right);
        }
      }
      result++;
    }

    return result;

  }

}

class TreeNodeMaximumDepthOfBinaryTree {
  int val;
  TreeNodeMaximumDepthOfBinaryTree left;
  TreeNodeMaximumDepthOfBinaryTree right;
  TreeNodeMaximumDepthOfBinaryTree(int x) { val = x; }
}
