package com.qiming.algorithm;

/**
 * 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。我们希望将这个二叉搜索树转化为双向循环链表。
 * 链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。（对原题有所改动）
 *
 *
 * 思路：中序遍历，认为到根结点的时候，左边是已经排序好的了，而右边在之后排序
 *
 *
 */
public class ConvertNode {

  // 中序遍历，访问该节点的时候，对其做如下操作：
  // 1.将当前被访问节点curr的左孩子置为前驱pre（中序）
  // 2.若前驱pre不为空，则前驱的右孩子置为当前被访问节点curr
  // 3.将前驱pre指向当前节点curr，即访问完毕

  // 上述形成的是一个非循环的双向链表
  // 需进行头尾相接
  NodeConvertNode pre=null;

  public NodeConvertNode treeToDoublyList(NodeConvertNode root) {

    if(root==null) return root;
    NodeConvertNode p=root,q=root;
    //下面是要做循环链表
    while(p.left!=null) p=p.left;
    while(q.right!=null) q=q.right;
    inorder(root);
    p.left=q;
    q.right=p;
    return p;


  }

  private void inorder(NodeConvertNode curr){
    if(curr==null) return;

    /**
     * 要用left和right表示前驱和后驱
     */
    inorder(curr.left);

    curr.left=this.pre;
    if(this.pre!=null) this.pre.right=curr;
    pre = curr;

    inorder(curr.right);
  }


}

class NodeConvertNode {
  public int val;
  public NodeConvertNode left;
  public NodeConvertNode right;

  public NodeConvertNode() {}

  public NodeConvertNode(int _val) {
    val = _val;
  }

  public NodeConvertNode(int _val,NodeConvertNode _left,NodeConvertNode _right) {
    val = _val;
    left = _left;
    right = _right;
  }
}