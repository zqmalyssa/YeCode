package com.qiming.pom.redis.setnx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RedisLock {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  /**
   * 加锁
   * @param key
   * @param value 当前时间+起始时间
   * @return
   */
  public boolean lock(String key, String value) {
    if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)) {
      return true;
    }

    //解决死锁，且当多个线程同时来时，只会让一个线程拿到锁
    String currentValue = stringRedisTemplate.opsForValue().get(key);
    //如果过期
    if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
      //获取上一个锁的时间
      String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);
      if (StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
        return true;
      }
    }

    return false;
  }

  public void unlock(String key, String value) {
    try {
      String currentValue = stringRedisTemplate.opsForValue().get(key);
      if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
      }

    } catch (Exception e) {
      System.out.println("Redis解锁失败");

    }
  }

}
