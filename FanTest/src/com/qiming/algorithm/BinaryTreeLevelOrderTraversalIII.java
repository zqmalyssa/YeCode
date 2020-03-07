package com.qiming.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 III
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 思路：还是老套路，但是加个boolean变量，每层变化下方向，配合linkedlist的特性
 *
 *
 */
public class BinaryTreeLevelOrderTraversalIII {

  public List<List<Integer>> levelOrder(TreeNodeBinaryTreeLevelOrderTraversalIII root) {

    if (root == null) {
      return new LinkedList<>();
    }

    List<List<Integer>> list = new LinkedList<>();
    Queue<TreeNodeBinaryTreeLevelOrderTraversalIII> queue = new LinkedList();
    queue.offer(root);
    boolean leftToRight = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> inside = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNodeBinaryTreeLevelOrderTraversalIII p = queue.poll();
        if (leftToRight) {
          inside.addLast(p.val);
        } else {
          inside.addFirst(p.val);
        }

        if (p.left != null) {
          queue.offer(p.left);
        }
        if (p.right != null) {
          queue.offer(p.right);
        }
      }
      list.add(inside);
      leftToRight = !leftToRight;
    }

    return list;

  }

}


class TreeNodeBinaryTreeLevelOrderTraversalIII {

  int val;
  TreeNodeBinaryTreeLevelOrderTraversalIII left;
  TreeNodeBinaryTreeLevelOrderTraversalIII right;
  TreeNodeBinaryTreeLevelOrderTraversalIII(int x) { val = x; }

}