package com.wbo112.scheduledemo;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTest1 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                System.out.println("scheduleAtFixedRate start :" + LocalDateTime.now());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("scheduleAtFixedRate end :" + LocalDateTime.now());
            }
        }, 10, 3, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println("scheduleWithFixedDelay start :" + LocalDateTime.now());
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("scheduleWithFixedDelay end :" + LocalDateTime.now());
//            }
//        }, 0, 3, TimeUnit.SECONDS);
    }
}
