package com.wbo112.juc;

import java.util.concurrent.locks.LockSupport;

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

Thread thread=new Thread(()->{
    Thread.currentThread().interrupt();
    System.out.println(Thread.currentThread().isInterrupted());
    System.out.println(Thread.currentThread().isInterrupted());
});
thread.start();
Thread.sleep(1000);
        System.out.println(thread.isInterrupted());
       // Thread.currentThread().join();
    }
}
