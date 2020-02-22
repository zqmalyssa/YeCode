package com.qiming.test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioStandard {

  public static void main(String[] args) {
    String src = "E:\\Code\\NioTestSample\\src.txt";
    String dst = "E:\\Code\\NioTestSample\\dst.txt";
    try {
      copyFileUseNio(src, dst);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void ReadFromFileByNio() throws IOException {
    //第一步，获取通道
    FileInputStream fin = new FileInputStream("123.txt");
    FileChannel fc = fin.getChannel();

    //第二步，创建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    //第三步，将数据从通道读到缓冲区
    fc.read(buffer);

  }


  public void WriteToFileByNio() throws IOException {
    //第一步，获取通道
    FileOutputStream fout = new FileOutputStream("123.txt");
    FileChannel fc = fout.getChannel();

    //第二步，创建缓冲区，将数据放入缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    Byte[] message = new Byte[10];
    for (int i = 0; i < message.length; i++) {
      buffer.put(message[i]);
    }
    buffer.flip();

    //第三步，将缓冲区数据写入通道
    fc.write(buffer);
  }

  public static void copyFileUseNio(String src, String dst) throws IOException{
    //声明源文件和目标文件
    FileInputStream fi = new FileInputStream(new File(src));
    FileOutputStream fo = new FileOutputStream(new File(dst));

    //获取传输通道
    FileChannel inChannel = fi.getChannel();
    FileChannel outChannel = fo.getChannel();

    //获得容器buffer
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    while(true) {
      //判断是否读完文件
      int eof = inChannel.read(buffer);
      if (eof == -1) {
        break;
      }
      //重设一下buffer的position=0，limit=position
      buffer.flip();
      //开始写
      outChannel.write(buffer);
      //写完要重置buffer，重设position=0, limit=capacity
      buffer.clear();
    }
    inChannel.close();
    outChannel.close();
    fi.close();
    fo.close();
  }

}
