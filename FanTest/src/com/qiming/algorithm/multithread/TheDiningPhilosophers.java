package com.qiming.algorithm.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家进餐
 *
 * 5 个沉默寡言的哲学家围坐在圆桌前，每人面前一盘意面。叉子放在哲学家之间的桌面上。（5 个哲学家，5 根叉子），所有的哲学家都只会在思考和进餐两种行为间交替。
 * 哲学家只有同时拿到左边和右边的叉子才能吃到面，而同一根叉子在同一时间只能被一个哲学家使用。每个哲学家吃完面后都需要把叉子放回桌面以供其他哲学家吃面。
 * 只要条件允许，哲学家可以拿起左边或者右边的叉子，但在没有同时拿到左右叉子时不能进食。设计一个进餐规则（并行算法）使得每个哲学家都不会挨饿；也就是说，
 * 在没有人知道别人什么时候想吃东西或思考的情况下，每个哲学家都可以在吃饭和思考之间一直交替下去。
 *
 * 思路，一个Semaphore和一个ReentrantLock数组
 *
 *
 */
public class TheDiningPhilosophers {

  private ReentrantLock[] lockList = {new ReentrantLock(),
      new ReentrantLock(),
      new ReentrantLock(),
      new ReentrantLock(),
      new ReentrantLock()};

  private Semaphore eatLimit = new Semaphore(4);

  public TheDiningPhilosophers() {

  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(int philosopher,
      Runnable pickLeftFork,
      Runnable pickRightFork,
      Runnable eat,
      Runnable putLeftFork,
      Runnable putRightFork) throws InterruptedException {

    int leftFork = (philosopher + 1) % 5;	//左边的叉子 的编号
    int rightFork = philosopher;	//右边的叉子 的编号

    eatLimit.acquire();	//限制的人数 -1

    lockList[leftFork].lock();	//拿起左边的叉子
    lockList[rightFork].lock();	//拿起右边的叉子

    pickLeftFork.run();	//拿起左边的叉子 的具体执行
    pickRightFork.run();	//拿起右边的叉子 的具体执行

    eat.run();	//吃意大利面 的具体执行

    putLeftFork.run();	//放下左边的叉子 的具体执行
    putRightFork.run();	//放下右边的叉子 的具体执行

    lockList[leftFork].unlock();	//放下左边的叉子
    lockList[rightFork].unlock();	//放下右边的叉子

    eatLimit.release();//限制的人数 +1

  }

}
