package com.wbo112.jedis.config;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class SimpleRedisLock implements ILock {

    private final String name;
    private static final String KEY_PREFIX = "lock:";
    //private Jedis jedis=new Jedis("192.168.50.20",6379);

    public SimpleRedisLock(String name, StringRedisTemplate stringRedisTemplate) {
        this.name = name;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean tryLock(long timeout) {
        long threadId = Thread.currentThread().getId();
        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(KEY_PREFIX + name, String.valueOf(threadId), timeout, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(result);
    }

    @Override
    public void unLock() {
        stringRedisTemplate.delete(KEY_PREFIX + name);
    }
}
