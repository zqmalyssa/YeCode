package com.qiming.designpattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自己实现的装饰者，将大写文本转换成小写
 */
public class InputTest {

  public static void main(String[] args) {
    try {
      int c;
      InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("E:\\Code\\TestDataSample\\word1.txt")));
      while ((c = in.read()) >= 0) {
        System.out.print((char) c);
      }
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
