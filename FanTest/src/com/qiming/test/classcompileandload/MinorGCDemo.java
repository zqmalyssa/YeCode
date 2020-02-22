package com.qiming.test.classcompileandload;

/**
 * MinorGC的一个例子
 *
 * -Xmx40M -Xms40M -Xmn16M -verbose:gc -XX:+PrintGCDetails
 *
 * 所以eden是12MB，S0和S1是2M，旧生代是24MB
 *
 * 第一次，eden11MB了，再分配1M就不够了，发生GC，完成后，eden留下新分配的1M，object被扔到了S区，
 *
 * [GC (Allocation Failure) [PSYoungGen: 11507K->1880K(14336K)] 11507K->1888K(38912K), 0.0407404 secs] [Times: user=0.00 sys=0.00, real=0.05 secs]
 *
 * PS说明使用了PS GC，11507K->1880K(14336K)表示在GC前，新生代使用空间11507K，回收后新生代使用空间1880K，新生代总共可用空间是14336K
 *
 * 11507K->1888K(38912K)表示在GC前，堆使用空间11507K，回收后堆使用空间为1888K，总共可用空间为38912K，0.0407404 secs表示了此次minorGC的时间
 *
 * [Times: user=0.00 sys=0.00, real=0.05 secs]表示MinorGC占用cpu user和sys的百分比，以及消耗的总时间
 *
 * 第二次也是Eden空间不足触发，这次可看见S的另一个空间有使用率了，说明S0和S1进行了交换，即From变成To，To变成From
 *
 */
public class MinorGCDemo {

  public static void main(String[] args) throws Exception{
    Thread.sleep(10000);
    //object是不会被回收的，放在了S0中
    MemoryObject object = new MemoryObject(1024*1024);
    for (int i = 0; i < 2; i++) {
      happenMinorGC(11);
      Thread.sleep(2000);
    }
  }


  private static void happenMinorGC(int happenMinorGCIndex) throws Exception{
    for (int i = 0; i < happenMinorGCIndex; i++) {
      //if成立前已经分了11MB在eden中了，再分配就不行了，因此触发了MinorGC
      if (i == happenMinorGCIndex - 1) {
        Thread.sleep(2000);
        System.out.println("minor gc should happen");
      }
      new MemoryObject(1024*1024);
    }
  }

}

class MemoryObject {
  private byte[] bytes;
  public MemoryObject(int objectSize) {
    this.bytes = new byte[objectSize];
  }
}