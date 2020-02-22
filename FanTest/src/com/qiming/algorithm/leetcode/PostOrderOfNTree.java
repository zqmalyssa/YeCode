package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历
 * 非递归
 */

public class PostOrderOfNTree {

  public static void main(String[] args) {

  }

  public List<Integer> postorder(NNode root) {
    List result =  new LinkedList();
    if (root == null) {
      return result;
    }
    NNode p = root;
    Stack stack = new Stack();
    while (p != null) {
      stack.push(p);
      List<NNode> children = p.children;
      if (children != null && children.size() > 0) {
        for (int i = 0; i < children.size(); i++) {
          if (children.get(i) != null) {
          }
        }
      }

    }
    return null;
  }

}


class NNode {
  public int val;
  public List<NNode> children;

  public NNode() {}

  public NNode(int _val, List<NNode> _children) {
    val = _val;
    children = _children;
  }
}