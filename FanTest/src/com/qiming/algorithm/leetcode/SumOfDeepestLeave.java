package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层数最深叶子节点的和
 *
 * 思路 使用层序遍历，计算每一层的和，只要还有下一层累加和就重置，最后结果就是最后一层的和
 */
public class SumOfDeepestLeave {

  public static void main(String[] args) {
    //自己写测试用例吧
  }

  private static int sumOfeepestLeave(TreeNodeSumOfDeepestLeave root) {
    if (root == null) {
      return 0;
    }
    Queue queue = new LinkedList();
    queue.offer(root);

    //改造基本的树的层次遍历
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      result = 0; //每一层先置为0
      for (int i = 0; i < size; i++) {
        TreeNodeSumOfDeepestLeave p = (TreeNodeSumOfDeepestLeave)queue.poll();
        result += p.val;
        if (p.left != null) {
          queue.offer(p.left);
        }
        if (p.right != null) {
          queue.offer(p.right);
        }
      }
    }
    return result;
  }

}


class TreeNodeSumOfDeepestLeave {

  int val;
  TreeNodeSumOfDeepestLeave left;
  TreeNodeSumOfDeepestLeave right;
  public TreeNodeSumOfDeepestLeave(int val) {
    this.val = val;
    left = null;
    right = null;
  }

}