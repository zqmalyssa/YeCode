package com.qiming.algorithm.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的最小深度
 *
 * 层次遍历
 */

public class MinimumDepthOfBinTree {

  public int run(TreeNode root) {

    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    //层次遍历
    int depth = 0;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      int len = queue.size();
      depth++;
      for (int i = 0; i < len; i++) {
        TreeNode cur = queue.poll();
        if (cur.left == null && cur.right == null) {
          return depth;
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
    return 0;
  }

}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}