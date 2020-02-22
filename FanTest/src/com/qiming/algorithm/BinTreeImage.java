package com.qiming.algorithm;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 输入一个二叉树，函数输出它的镜像
 *
 */
public class BinTreeImage {

  public static void main(String args[]) {

    BinTreeNode b1 = new BinTreeNode(5, null, null);
    BinTreeNode b2 = new BinTreeNode(7, null, null);
    BinTreeNode b3 = new BinTreeNode(6, b1, b2);
    BinTreeNode b4 = new BinTreeNode(9, null, null);
    BinTreeNode b5 = new BinTreeNode(11, null, null);
    BinTreeNode b6 = new BinTreeNode(10, b4, b5);

    BinTreeNode b7 = new BinTreeNode(8, b3, b6);

    //层次遍历
    LinkedList listOld = levelOrder(b7);

    generateImage(b7);

    LinkedList list = levelOrder(b7);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(((BinTreeNode)listOld.get(i)).getVal());
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.println(((BinTreeNode)list.get(i)).getVal());
    }



  }

  private static void generateImage(BinTreeNode root) {
    if (root == null || (root.getLeft() == null && root.getRight() == null)) {
      return;
    }

    BinTreeNode tmp = root.getLeft();
    root.setLeft(root.getRight());
    root.setRight(tmp);

    if (root.getLeft() != null) {
      generateImage(root.getLeft());
    }

    if (root.getRight() != null) {
      generateImage(root.getRight());
    }
  }

  private static LinkedList levelOrder(BinTreeNode root) {
    LinkedList list = new LinkedList();
    if (root == null) {
      return list;
    }
    LinkedBlockingQueue q = new LinkedBlockingQueue();
    try {
      //put和take相对
      q.put(root);
      while (!q.isEmpty()) {
        BinTreeNode p = (BinTreeNode)q.take();
        list.addLast(p);
        if (p.getLeft() != null) {
          q.put(p.getLeft());
        }
        if (p.getRight() != null) {
          q.put(p.getRight());
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return list;
  }

}
