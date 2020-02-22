package com.qiming.designpattern.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自己实现一个JAVA_IO的装饰者
 *
 * 增强的功能，将所有大写改成小写
 */

public class LowerCaseInputStream extends FilterInputStream {

  public LowerCaseInputStream(InputStream in) {
    super(in);
  }

  /**
   * 针对字节的
   * @return
   * @throws IOException
   */
  @Override
  public int read() throws IOException {
    int c = super.read();
    return (c == -1 ? c : Character.toLowerCase((char)c));
  }

  /**
   * 针对字节数组的
   * @param b
   * @param off
   * @param len
   * @return
   * @throws IOException
   */
  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    int result = super.read(b, off, len);
    for (int i = off; i < off + result; i++) {
      b[i] = (byte)Character.toLowerCase((char)b[i]);
    }
    return result;
  }
}
