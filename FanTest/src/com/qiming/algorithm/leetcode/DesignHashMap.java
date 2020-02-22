package com.qiming.algorithm.leetcode;

import java.util.Arrays;

/**
 * 设计哈希映射
 *
 * 不使用任何内建的哈希表库设计一个哈希映射，具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 *
 * remove(key)：如果映射中存在这个键，删除这个数值对
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 * 思路：还蛮重要的，hashmap的实现，取巧的是用全值数组，还有就是正常写法，不考虐扩容，用双端队列(这才是要掌握的方法)
 *
 */
public class DesignHashMap {

//  int table[];

  class Node {
    int key, value;
    Node pre, next;

    Node (int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private Node[] data;
  private int length = 100;

  /** Initialize your data structure here. */
  public DesignHashMap() {
//    table = new int[1000000];
//    Arrays.fill(table, -1);
    data = new Node[length];
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
//    table[key] = value;
    int index = key % length;
    Node curr = data[index];
    if (curr == null) {
      Node node = new Node(key, value);
      data[index] = node;
      return;
    } else {
      while (true) {
        if (curr.key == key) {
          curr.value = value;
          return;
        }
        if (curr.next == null) {
          Node node = new Node(key, value);
          node.pre = curr;
          curr.next = node;
          return;
        } else {
          //一直找到最后
          curr = curr.next;
        }
      }
    }

  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
//    return table[key];
    int index = key % length;
    Node curr = data[index];
    while (curr != null) {
      if (curr.key == key) {
        return curr.value;
      }
      curr = curr.next;
    }
    return -1;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
//    table[key] = -1;
    int index = key % length;
    Node curr = data[index];
    //就是第一个结点
    if (curr != null && curr.key == key) {
      Node next = curr.next;
      if (next != null) {
        next.pre = null;
      }
      data[index] = next;
      return;
    }
    while (curr != null) {
      if (curr.key == key) {
        Node next = curr.next;
        Node pre = curr.pre;
        if (next != null) {
          next.pre = pre;
        }
        if (pre != null) {
          pre.next = next;
        }
        return;
      }
      curr = curr.next;
    }

  }

}

/**
 * Your DesignHashMap object will be instantiated and called as such:
 * DesignHashMap obj = new DesignHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */