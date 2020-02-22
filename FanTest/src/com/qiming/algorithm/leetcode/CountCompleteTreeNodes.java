package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 思路，递归和非递归的方式都可以去解，然后是充分利用完全二叉树性质的解，
 *
 * 它是一棵空树或者它的叶子节点只出在最后两层，若最后一层不满则叶子节点只在最左侧。再来回顾一下满二叉的节点个数怎么计算，如果满二叉树的层数为h，则总节点数为：2^h - 1.
 * 么我们来对root节点的左右子树进行高度统计，分别记为left和right,有以下两种结果：
 * 1、left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是2^left - 1，加上当前这个root节点，则正好是2^left。再对右子树进行递归统计。
 * 2、left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。同理，右子树节点+root节点，总数为2^right。再对左子树进行递归查找。
 *
 * 关于如何计算二叉树的层数，可以利用下面的递归来算，当然对于完全二叉树，可以利用其特点，不用递归直接算，就是左子树的深度
 *
 * 如何计算2^left，最快的方法是移位计算，因为运算符的优先级问题，记得加括号哦。速度非常快
 *
 *
 */
public class CountCompleteTreeNodes {

  public int countNodes(TreeNodeCountCompleteTreeNodes root) {

//    if (root == null) {
//      return 0;
//    }
//
//    Queue<TreeNodeCountCompleteTreeNodes> queue = new LinkedList();
//    queue.offer(root);
//    int result = 0;
//    while (!queue.isEmpty()) {
//      int size = queue.size();
//      for (int i = 0; i < size; i++) {
//        TreeNodeCountCompleteTreeNodes p = queue.poll();
//        if (p.left != null) {
//          queue.offer(p.left);
//        }
//        if (p.right != null) {
//          queue.offer(p.right);
//        }
//      }
//      result += size;
//    }
//
//    return result;
    if(root == null){
      return 0;
    }
    int left = countLevel(root.left);
    int right = countLevel(root.right);
    if(left == right){
      return countNodes(root.right) + (1<<left);
    }else{
      return countNodes(root.left) + (1<<right);
    }


  }

  private int countLevel(TreeNodeCountCompleteTreeNodes root){
    int level = 0;
    while(root != null){
      level++;
      root = root.left;
    }
    return level;
  }


}


class TreeNodeCountCompleteTreeNodes {

  int val;
  TreeNodeCountCompleteTreeNodes left;
  TreeNodeCountCompleteTreeNodes right;
  TreeNodeCountCompleteTreeNodes(int x) {val = x;};

}