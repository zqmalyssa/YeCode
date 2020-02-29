package com.qiming.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 思路：树的层次遍历
 *
 */
public class PrintFromTopToButtom {

  public int[] levelOrder(TreeNodePrintFromTopToButtom root) {

    if (root == null) {
      return new int[0];
    }

    List<Integer> list = new LinkedList<>();
    Queue<TreeNodePrintFromTopToButtom> queue = new LinkedList();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNodePrintFromTopToButtom p = queue.poll();
        list.add(p.val);
        if (p.left != null) {
          queue.offer(p.left);
        }
        if (p.right != null) {
          queue.offer(p.right);
        }
      }
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = list.get(i);
    }
    return result;
  }

}


class TreeNodePrintFromTopToButtom {

  int val;
  TreeNodePrintFromTopToButtom left;
  TreeNodePrintFromTopToButtom right;
  TreeNodePrintFromTopToButtom(int x) {val = x;}

}