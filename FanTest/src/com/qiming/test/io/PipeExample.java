package com.qiming.test.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 读写管道，只能为同一个JVM进程中的不同线程进行通信。
 */
public class PipeExample {

  public static void main(String[] args) throws IOException {
    final PipedOutputStream output = new PipedOutputStream();
    final PipedInputStream  input  = new PipedInputStream(output);
    Thread thread1 = new Thread(new Runnable() {
      public void run() {
        try {
          output.write("Hello world, pipe!".getBytes());
        } catch (IOException e) {
        }
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      public void run() {
        try {
          int data = input.read();
          while( data != -1){
            System. out.print((char) data);
            data = input.read();
          }
        } catch (IOException e) {
        } finally{
          try {
            input.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread1.start();
    thread2.start();
  }


}
