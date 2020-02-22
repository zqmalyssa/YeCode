package com.qiming.test.classcompileandload;

/**
 * 这个例子用来说明class文件格式
 *
 * javac -g Foo.java (加-g是为了生成所有的调试信息，包括局部变量名及行号信息，不加-g默认只生成行号信息)
 *
 * 之后通过javap -c -s -l -verbose Foo来查看编译后的class文件
 *
 */
public class Foo {

  private static final int MAX_COUNT = 1000;
  private static int count = 0;
  public int bar() throws Exception {
    if (++count >= MAX_COUNT) {
      count = 0;
      throw new Exception("count overflow");
    }
    return count;
  }

}
