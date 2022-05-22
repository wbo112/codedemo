package com.wbo112.jedis.config;

public interface ILock {
    boolean tryLock(long timeout);
    void unLock();
}
