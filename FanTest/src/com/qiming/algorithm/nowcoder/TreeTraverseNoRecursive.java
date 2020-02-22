package com.qiming.algorithm.nowcoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的先序，中序，后序的非递归算法
 *         4
 *      5      7
 *   14   6  10   3
 *
 */

public class TreeTraverseNoRecursive {

  public static void main(String[] args) {
    BinTreeNode b1 = new BinTreeNode(4);
    BinTreeNode b2 = new BinTreeNode(5);
    BinTreeNode b3 = new BinTreeNode(7);
    BinTreeNode b4 = new BinTreeNode(14);
    BinTreeNode b5 = new BinTreeNode(6);
    BinTreeNode b6 = new BinTreeNode(10);
    BinTreeNode b7 = new BinTreeNode(3);
    b1.left = b2;
    b1.right = b3;
    b2.left = b4;
    b2.right = b5;
    b3.left = b6;
    b3.right = b7;

    List result = new LinkedList();
//    new TreeTraverseNoRecursive().preOrderTraverseNoRecursive(b1, result);
//    new TreeTraverseNoRecursive().inOrderTraverseNoRecursive(b1, result);
//    new TreeTraverseNoRecursive().postOrderTraverseNoRecursive(b1, result);
    new TreeTraverseNoRecursive().levelOrderTraverseNoRecursive(b1, result);
    for (int i = 0; i < result.size(); i++) {
      System.out.println(((BinTreeNode)result.get(i)).val);
    }
  }

  /**
   * 树的先序遍历
   * 内层循环中，沿着根结点P一直往左走，沿途访问经过的根结点，并将这些根结点的非空右子树入栈，直到p为空
   * 此时就应当取出沿途遇到的最后的非空右子树的根，即栈顶结点，然后在外层循环中继续先序遍历这棵以p指向的子树
   * 如果栈空，表示再没有右子树需要遍历了，外层循环结束，整个时间复杂度O(n)
   */
  private void preOrderTraverseNoRecursive(BinTreeNode root, List result) {
    if (root == null) {
      return;
    }
    BinTreeNode p = root;
    Stack s = new Stack();
    while (p != null) {
      while (p != null) {
        result.add(p);
        if (p.right != null) {
          s.push(p.right);
        }
        p = p.left;
      }
      if (!s.isEmpty()) {
        p = (BinTreeNode)s.pop();
      }
    }
  }

  /**
   * 树的中序遍历
   * 内层循环中，沿着根结点P一直向左走，沿途将根结点入栈，直到p为空，此时应当取出上一层的根结点访问之，
   * 然后转向该根结点的右子树进行中序遍历，如果栈跟p都为空，则说明没有更多的子树需要遍历了，时间复杂度O(n)
   */
  private void inOrderTraverseNoRecursive(BinTreeNode root, List result) {
    if (root == null) {
      return;
    }
    BinTreeNode p = root;
    Stack stack =  new Stack();
    while(p != null || !stack.isEmpty()) {
      while(p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        p = (BinTreeNode)stack.pop();
        result.add(p);
        p = p.right;
      }
    }
  }

  /**
   * 树的后序遍历
   * 内层的第一个while循环，沿着根结点p向左子树深入，如果左子树为空，则向右子树深入，沿途将根结点入栈，直到p为空
   * 第一个if语句说明应当取出栈顶根结点进行访问，此时栈顶结点为叶子或无右子树的单分支结点，访问p以后，说明p为根的子树访问完毕
   * 判断p是否为其父结点的右孩子，如果是，则说明只要访问其父亲就可以完成对以p的父亲为根的子树的遍历，以内层的第二个while循环完成
   * 如果不是，则转向其父结点的右子树继续后序遍历，如果栈和p都为空，则说明结束了。时间复杂度为O(n)
   */
  private void postOrderTraverseNoRecursive(BinTreeNode root, List result) {
    if (root == null) {
      return;
    }
    BinTreeNode p = root;
    Stack stack =  new Stack();
    while (p != null || !stack.isEmpty()) {
      while (p != null) { //先左后右不断深入
        stack.push(p);    //将根结点入栈
        if (p.left != null) {
          p = p.left;
        } else {
          p = p.right;
        }
      }

      if (!stack.isEmpty()) {
        p = (BinTreeNode)stack.pop(); //取出栈顶根结点访问之
        result.add(p);
      }

      //满足条件时，说明栈顶根结点右子树已访问，应出栈访问之
      while (!stack.isEmpty() && ((BinTreeNode)stack.peek()).right == p) {
        p = (BinTreeNode)stack.pop();
        result.add(p);
      }
      //转向栈顶根结点的右子树继续后序遍历
      if (!stack.isEmpty()) {
        p = ((BinTreeNode)stack.peek()).right;
      } else {
        p = null;
      }
    }
  }

  /**
   * 树的层次遍历
   * 用一个队列实现
   */
  private void levelOrderTraverseNoRecursive(BinTreeNode root, List result) {
    if (root == null) {
      return;
    }
    Queue queue = new LinkedList();
    queue.offer(root);
    while(!queue.isEmpty()) {
      BinTreeNode b = (BinTreeNode)queue.poll();
      result.add(b);
      if (b.left != null) {
        queue.offer(b.left);
      }
      if (b.right != null) {
        queue.offer(b.right);
      }
    }
  }

}

class BinTreeNode {

  int val;
  BinTreeNode left;
  BinTreeNode right;

  public BinTreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
