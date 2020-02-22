package com.qiming.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 *
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 思路：有点那什么意思，链表的方式是超时的！！！但是这里要说的是怎么保证是环，就是如果不是第m个元素，就将数值添加到arraylist的尾部，每次都移除第一个元素，这样还是能保证环的
 *
 * 这道题是一道约瑟夫环的问题，我们可以用数学的方法来做，迭代和递归
 *
 * f(n,m)=（f(n−1,m)+m)modn，且f(1,m)=0
 *
 */
public class LastLeftNum {

  public int lastRemaining(int n, int m) {
    int flag = 0;
    for (int i = 2; i <= n; i++) {
      flag = (flag + m) % i;
      //动态规划的思想，将f(n,m)替换成flag存储
    }
    return flag;

    //通过举例可以得出第一次删除的数字下标为(m-1)%n记为c，之后每一次删除的数字下标均为(c+m-1)%list.size()
//    if(n==0||m==0)
//      return -1;
//    List<Integer> list=new ArrayList<>();
//    for(int i=0;i<n;i++)
//      list.add(i);
//    int c=(m-1)%n;
//    while(list.size()!=1) {
//      list.remove(c);
//      c=(c+m-1)%list.size();
//    }
//    return list.get(0);


  }


}
