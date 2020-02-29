package com.qiming.algorithm;

/**
 * 将1032032013012输出成1亿三千七百八十二万五千六百一十一
 *
 *
 */
public class ChangeNum {


  public static void main(String[] args) {





  }

  public String changeNum(int num) {

//    StringBuilder sb = new StringBuilder();
//
//    while (num / 1000 != 0) {
//      int leftNum = num % 10;
//      while (leftNum / 10 != 0) {
//        int digit = leftNum % 10;
//        sb.append(numToChar(digit));
//        sb.append(numToCharName());
//      }
//    }
    return null;

  }

  private char numToCharName(int numName) {

    switch (numName) {
      case 1:
        return '千';
      case 2:
        return '百';
      case 3:
        return '十';
    }
    return '1';
  }

  private char numToChar(int num) {

    switch (num) {
      case 1:
        return '一';
      case 2:
        return '二';
      case 3:
        return '三';
      case 4:
        return '四';
      case 5:
        return '五';
      case 6:
        return '六';
      case 7:
        return '七';
      case 8:
        return '八';
      case 9:
        return '九';
      case 10:
        return '十';
    }

    return '1';
  }


}
