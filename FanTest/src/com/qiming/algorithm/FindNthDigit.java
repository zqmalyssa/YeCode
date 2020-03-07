package com.qiming.algorithm;

/**
 * 数字序列中某一位的数字
 *
 * 数字以123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 思路：有规律的，1位的数字是9个 2位的数字是 90个 3位的数字是 900 又分别对应 9位数，180位数 和 2700位数
 *
 */
public class FindNthDigit {

  public int findNthDigit(int n) {
    long num=n;

    long size=1;
    long max=9;

    while(n>0){
      //判断不在当前位数内
      if(num-max*size>0){
        num=num-max*size;
        size++;
        max=max*10;
      }else{
        long count=num/size;
        long left=num%size;
        if(left==0){
          return (int) (((long)Math.pow(10, size-1)+count-1)%10);
        }else{
          return (int) (((long)Math.pow(10, size-1)+count)/((long)Math.pow(10, (size-left)))%10);
        }
      }
    }

    return 0;

  }

}
