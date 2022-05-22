package com.wbo112.juc;

public class CacheLine {
    private volatile long a;
    //private long a1,a2,a3,a4,a5,a6,a7;
    private volatile   long b=10;

    public static void main(String[] args) {
        CacheLine cacheLine = new CacheLine();
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                   // Thread.sleep(1);
                    cacheLine.a += 1;
                   // cacheLine.b += 1;


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();

        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 10000000; i++) {
            String.valueOf(cacheLine.b);
        }
        System.out.println(System.currentTimeMillis() - start);
        thread.interrupt();
        System.out.println(sum);

    }

}
