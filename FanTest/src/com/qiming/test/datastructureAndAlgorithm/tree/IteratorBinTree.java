package com.qiming.test.datastructureAndAlgorithm.tree;

import com.qiming.test.datastructureAndAlgorithm.common.AlgorithmType;
import com.qiming.test.datastructureAndAlgorithm.common.Iterator;
import com.qiming.test.datastructureAndAlgorithm.linearlist.LinkedList;
import com.qiming.test.datastructureAndAlgorithm.linearlist.LinkedListDLNode;
import com.qiming.test.datastructureAndAlgorithm.stack.Stack;
import com.qiming.test.datastructureAndAlgorithm.stack.StackSLinked;


public class IteratorBinTree implements BinTreeMethod{

  private BinTreeNode root;

  public Iterator preOrder(Enum type) {
    LinkedList list = new LinkedListDLNode();
    if (type.equals(AlgorithmType.Recursion)) {
      preOrderRecursion(this.root, list);
    } else if (type.equals(AlgorithmType.Traverse)) {
      preOrderTraverse(this.root, list);
    }
    return list.elements();
  }

  //先序遍历递归算法
  private void preOrderRecursion(BinTreeNode rt, LinkedList list) {
    if (rt == null) {
      return;
    }
    list.insertLast(rt);
    preOrderRecursion(rt.getLChild(), list);
    preOrderRecursion(rt.getRChild(), list);
  }

  //先序遍历非递归算法
  private void preOrderTraverse(BinTreeNode rt, LinkedList list) {
    if (rt == null) {
      return;
    }
    BinTreeNode p = rt;
    Stack s = new StackSLinked();
    while (p != null) {
      while (p != null) {  //从左走到尽头
        list.insertLast(p);  //访问根，先序遍历的原则
        if (p.hasRChild()) {  //右子树根结点入栈
          s.push(p.getRChild());
        }
        p = p.getLChild();
      }
      if (!s.isEmpty()) {
        p = (BinTreeNode)s.pop();
      }
    }

  }

  public int getSize() {
    return 0;
  }

  public boolean isEmpty() {
    return false;
  }

  public BinTreeNode getRoot() {
    return null;
  }

  public int getHeight() {
    return 0;
  }

  public BinTreeNode find(Object e) {
    return null;
  }

  public Iterator inOrder(Enum type) {
    return null;
  }

  public Iterator postOrder(Enum type) {
    return null;
  }

  public Iterator levelOrder(Enum type) {
    return null;
  }
}
