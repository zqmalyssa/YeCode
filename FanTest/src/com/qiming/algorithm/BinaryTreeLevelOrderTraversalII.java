package com.qiming.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 思路：二叉树的层次遍历，只是输出的返回值不一样，调整一下代码即可
 *
 */
public class BinaryTreeLevelOrderTraversalII {

  public List<List<Integer>> levelOrder(TreeNodeBinaryTreeLevelOrderTraversalII root) {

    if (root == null) {
      return new LinkedList<>();
    }

    List<List<Integer>> list = new LinkedList<>();
    Queue<TreeNodeBinaryTreeLevelOrderTraversalII> queue = new LinkedList();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> inside = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNodeBinaryTreeLevelOrderTraversalII p = queue.poll();
        inside.add(p.val);
        if (p.left != null) {
          queue.offer(p.left);
        }
        if (p.right != null) {
          queue.offer(p.right);
        }
      }
      list.add(inside);
    }

    return list;

  }

}


class TreeNodeBinaryTreeLevelOrderTraversalII{

  int val;
  TreeNodeBinaryTreeLevelOrderTraversalII left;
  TreeNodeBinaryTreeLevelOrderTraversalII right;
  TreeNodeBinaryTreeLevelOrderTraversalII(int x) { val = x; }


}