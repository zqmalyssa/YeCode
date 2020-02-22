package com.qiming.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一颗二叉树是不是完全二叉树
 *
 *
 * 思路：有四种情况，左空右空，左空右有，左有右空，左有右有
 * 左空右有肯定不是完全二叉树了，左有右空和左空右空说明下一个节点(层次)肯定是叶子结点。此时看队列里剩余的元素，应该都是叶子了，如有不是，就不是完全
 *
 *
 */
public class IsCompleteBinTree {

  public static void main(String[] args) {

  }

  private boolean isCompleteBinTree(TreeNodeIsCompleteBinTree root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNodeIsCompleteBinTree> queue = new LinkedList();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNodeIsCompleteBinTree p = queue.poll();
      if (p.left != null) {
        queue.offer(p.left);
        if (p.right != null) {
          //左有右有
          queue.offer(p.right);
        } else {
          //左有右空
          break;
        }
      } else {
        if (p.right != null) {
          //左无右有
          return false;
        } else {
          //左无右无
          break;
        }
      }
    }

    while (!queue.isEmpty()) {
      TreeNodeIsCompleteBinTree p = queue.poll();
      if (p.left != null || p.right != null) {
        return false;
      }
    }
    //单结点，为完全二叉树
    return true;
  }

}

class TreeNodeIsCompleteBinTree{

  int val;
  TreeNodeIsCompleteBinTree left;
  TreeNodeIsCompleteBinTree right;

  public TreeNodeIsCompleteBinTree(int val) {
    this.val = val;
  }
}
