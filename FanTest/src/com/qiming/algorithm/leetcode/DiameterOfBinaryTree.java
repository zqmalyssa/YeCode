package com.qiming.algorithm.leetcode;

/**
 * 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 思路：小心陷阱，假设我们知道对于每个节点最长箭头距离分别为 L, RL,R，那么最优路径经过 L + R + 1 个节点。
 * 按照常用方法计算一个节点的深度：max(depth of node.left, depth of node.right) + 1。在计算的同时，经过这个节点的路径
 * 长度为 1 + (depth of node.left) + (depth of node.right) 。搜索每个节点并记录这些路径经过的点数最大值，期望长度是结果，要记得每个节点都要比较就行了
 *
 */
public class DiameterOfBinaryTree {

  int ans = 0;

  public int diameterOfBinaryTree(TreeNodeDiameterOfBinaryTree root) {

    /**
     * 最大路径一定经过根结点。。这个想法错了，最大值也可以在子树里面。。
     */
//    if (root == null) {
//      return 0;
//    }
//
//    int letfDepth = calDepth(root.left);
//    int rightDepth = calDepth(root.right);
//
//    return letfDepth + rightDepth;
    depth(root);
    return ans;


  }

  private int depth(TreeNodeDiameterOfBinaryTree root) {

    if (root == null) {
      return 0;
    }
    int L = depth(root.left);
    int R = depth(root.right);
    ans = Math.max(ans, L + R);
    return Math.max(L, R) + 1;
  }

  private int calDepth(TreeNodeDiameterOfBinaryTree root) {
    if (root == null) {
      return 0;
    }
    //也是种递归求高度的方法
    return Math.max(calDepth(root.left), calDepth(root.right)) + 1;
  }

}

class TreeNodeDiameterOfBinaryTree {

  int val;
  TreeNodeDiameterOfBinaryTree left;
  TreeNodeDiameterOfBinaryTree right;
  TreeNodeDiameterOfBinaryTree(int x) { val = x; }

}
