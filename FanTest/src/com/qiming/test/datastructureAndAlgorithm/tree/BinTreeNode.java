package com.qiming.test.datastructureAndAlgorithm.tree;

import com.qiming.test.datastructureAndAlgorithm.common.Node;

/**
 * 二叉树包含左孩子，右孩子，父亲结构结点
 *
 */
public class BinTreeNode implements Node {

  private Object data;
  private BinTreeNode parent;
  private BinTreeNode lChild;
  private BinTreeNode rChild;

  private int height;  //以该结点为根的子树的高度
  private int size;    //该结点的子孙数(包含结点本身)

  public BinTreeNode() {
    this(null);
  }

  public BinTreeNode(Object e) {
    this.data = e;
    this.height = 0;
    this.size = 0;
    parent = lChild = rChild = null;
  }

  //判断是否有父亲
  public boolean hasParent() {
    return parent != null;
  }

  //判断是否有左孩子
  public boolean hasLChild() {
    return lChild != null;
  }

  //判断是否有右孩子
  public boolean hasRChild() {
    return rChild != null;
  }

  //判断是否为叶子结点
  public boolean isLeaf() {
    return !hasLChild() && !hasRChild();
  }

  //判断是否为某结点的左孩子
  public boolean isLChild() {
    return hasParent() && this == parent.lChild;
  }

  //判断是否为某结点的右孩子
  public boolean isRChild() {
    return hasParent() && this == parent.rChild;
  }

  //取当前结点的高度，以该结点为根的树的高度
  public int getHeight() {
    return this.height;
  }

  //更新当前结点及其祖先的高度
  public void updateHeight() {
    int newH = 0;  //初始化为0
    if (hasLChild()) {
      newH = Math.max(newH, 1 + getLChild().getHeight());
    }
    if (hasRChild()) {
      newH = Math.max(newH, 1 + getRChild().getHeight());
    }
    if (newH == height) {
      return;
    }
    height = newH;
    if (hasParent()) {
      getParent().updateHeight();
    }
  }

  //取当前结点为根的树的结点树
  public int getSize() {
    return size;
  }

  //更新当前结点及其祖先的子孙数
  public void updateSize() {
    size = 1;   //初始化为1，结点本身
    if (hasLChild()) {
      size += getLChild().getSize();
    }
    if (hasRChild()) {
      size += getRChild().getSize();
    }
    if (hasParent()) {
      getParent().updateSize();
    }
  }

  //获取父结点
  public BinTreeNode getParent() {
    return parent;
  }

  //断开与父结点的关系
  public void sever() {
    if (!hasParent()) {
      return;
    }
    if (isLChild()) {
      parent.lChild = null;
    } else {
      parent.rChild = null;
    }
    parent.updateHeight();
    parent.updateSize();
    parent = null;
  }

  //获取左孩子
  public BinTreeNode getLChild() {
    return lChild;
  }

  //设置当前结点的左孩子，返回原左孩子
  public BinTreeNode setLChild(BinTreeNode lc) {
    BinTreeNode oldLC = this.lChild;
    if (hasLChild()) {
      lChild.sever();
    }
    if (lc != null) {
      lc.sever();
      this.lChild = lc;
      lc.parent = this;
      this.updateHeight();
      this.updateSize();
    }
    return oldLC;
  }

  //获取右孩子
  public BinTreeNode getRChild() {
    return rChild;
  }

  //设置当前结点的右孩子，返回原右孩子
  public BinTreeNode setRChild(BinTreeNode rc) {
    BinTreeNode oldRC = this.rChild;
    if (hasRChild()) {
      rChild.sever();
    }
    if (rc != null) {
      rc.sever();
      this.rChild = rc;
      rc.parent = this;
      this.updateHeight();
      this.updateSize();
    }
    return oldRC;
  }

  //node的实现方法
  public Object getData() {
    return this.data;
  }

  public void setData(Object obj) {
    this.data = obj;
  }
}
