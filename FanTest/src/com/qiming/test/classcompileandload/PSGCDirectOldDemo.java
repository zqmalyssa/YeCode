package com.qiming.test.classcompileandload;

/**
 * 示例，当新生代用PS GC时，如何直接去老年代分配内存
 *
 * -Xmx 20M -Xms 20M -Xmn 10M -XX:SurvivorRatio=8 -XX:+UseParallelGC
 */
public class PSGCDirectOldDemo {

  public static void main(String[] args) throws Exception {
    byte[] byte1 = new byte[1024*1024*2]; //2M
    byte[] byte2 = new byte[1024*1024*2]; //2M
    byte[] byte3 = new byte[1024*1024*2]; //2M

    System.out.println("Ready to direct allocate to old");
    Thread.sleep(3000);
    byte[] byte4 = new byte[1024*1024*4]; //4M
    Thread.sleep(3000);
  }

}
