package com.qiming.pom.redis.setnx;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 模拟秒杀
 */
public class SecKillService {

  @Autowired
  RedisLock redisLock;

  //超时时间10秒
  private static final int TIMEOUT = 10 * 1000;

  public void secKill(String productId) {
    long time = System.currentTimeMillis() + TIMEOUT;
    //加锁
    if (!redisLock.lock(productId, String.valueOf(time))) {
      throw new RuntimeException("人太多了，稍后再试");
    }

    //具体秒杀逻辑

    //解锁
    redisLock.unlock(productId, String.valueOf(time));
  }

}
