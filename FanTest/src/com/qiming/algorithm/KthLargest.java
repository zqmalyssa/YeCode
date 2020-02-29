package com.qiming.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 思路：二叉搜索树的特性，中序遍历的时候是排序的。但是这里要看清题目，是第K大节点，不是找最小的K，所以，可以用辅助list做，但是更妥的方法是再用二叉搜索树的性质，
 * 也就是先遍历右子树，再左子树，也就是从大到小排列了
 *
 */
public class KthLargest {


  public int kthLargest(TreeNodeKthLargest root, int k) {

//    if (root == null) {
//      return -1;
//    }
//    TreeNodeKthLargest p = root;
//    Stack<TreeNodeKthLargest> stack =  new Stack();
//    List<TreeNodeKthLargest> result = new ArrayList();
//    while(p != null || !stack.isEmpty()) {
//      while(p != null) {
//        stack.push(p);
//        p = p.left;
//      }
//      if (!stack.isEmpty()) {
//        p = stack.pop();
//        result.add(p);
//        p = p.right;
//      }
//    }
//
//    return result.get(result.size() - k).val;

    if (root == null) {
      return -1;
    }
    TreeNodeKthLargest p = root;
    Stack<TreeNodeKthLargest> stack =  new Stack();
    int num = 0;
    while(p != null || !stack.isEmpty()) {
      while(p != null) {
        stack.push(p);
        p = p.right;
      }
      if (!stack.isEmpty()) {
        p = stack.pop();
        num++;
        if (num == k) {
          return p.val;
        }
        p = p.left;
      }
    }

    return -1;
  }
}


class TreeNodeKthLargest {
  int val;
  TreeNodeKthLargest left;
  TreeNodeKthLargest right;
  TreeNodeKthLargest(int x) { val = x; }
}

