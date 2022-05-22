package com.wbo112.javabase;

public class SyncDemo {
    private static Object obj=new Object();
    public static void main(String[] args) {
        synchronized (obj){
            System.out.println("hello world");
        }
    }
    public synchronized void test(){
        System.out.println("test");
    }
}

