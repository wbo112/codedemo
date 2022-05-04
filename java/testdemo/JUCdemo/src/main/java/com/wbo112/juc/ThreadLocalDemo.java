package com.wbo112.juc;

public class ThreadLocalDemo {
    public final static ThreadLocal<String> threadLocal = new ThreadLocal<>() {
        @Override
        protected String initialValue() {
            return "initValue";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("init Value =" + threadLocal.get());
            threadLocal.set("abc");
            System.out.println("执行其他逻辑");
            String str = threadLocal.get();
            System.out.println(str);
            threadLocal.remove();
        }).start();
        Thread.currentThread().join();
        test1();
    }

    public static void test1() throws InterruptedException {
        ThreadLocal<String> threadLocal0 = new ThreadLocal<>();

        ThreadLocal<String> finalThreadLocal = threadLocal0;
        new Thread(() -> {
            finalThreadLocal.set("th0");
            System.out.println(finalThreadLocal.get());
            finalThreadLocal.remove();

        }).start();
        threadLocal0=null;
        Thread.currentThread().join();
    }
}
