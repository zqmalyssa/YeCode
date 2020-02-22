package com.qiming.pom.redis.usage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisUsageController {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @RequestMapping(value="/redis/string", method = RequestMethod.POST)
  public void setString() {
    //保存字符串
    stringRedisTemplate.opsForValue().set("aaa","111");
    stringRedisTemplate.opsForValue().set("bbb","222");
    stringRedisTemplate.opsForValue().set("ccc","333");
  }

}
