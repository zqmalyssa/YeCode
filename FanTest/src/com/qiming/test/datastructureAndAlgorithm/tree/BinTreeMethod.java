package com.qiming.test.datastructureAndAlgorithm.tree;

import com.qiming.test.datastructureAndAlgorithm.common.Iterator;

public interface BinTreeMethod {

  //返回二叉树的结点数
  public int getSize();

  //判断二叉树是否为空
  public boolean isEmpty();

  //返回二叉树的根节点
  public BinTreeNode getRoot();

  //返回二叉树的高度
  public int getHeight();

  //找到数据元素e所在的结点
  public BinTreeNode find(Object e);

  /**
   * 先序，中序，后序，按层遍历，结果由迭代器对象返回，type是递归还是非递归
   */

  public Iterator preOrder(Enum type);

  public Iterator inOrder(Enum type);

  public Iterator postOrder(Enum type);

  public Iterator levelOrder(Enum type);

}
