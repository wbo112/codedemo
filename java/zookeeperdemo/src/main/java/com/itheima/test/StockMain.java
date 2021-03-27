package com.itheima.test;

import com.itheima.bean.Stock;
import com.itheima.lock.DbLock;
//import com.itheima.lock.RedisLock;

//import javafx.application.Application;
import com.itheima.lock.ZkLock;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StockMain {

    //private static Lock lock = new ReentrantLock();
    private static Lock dbLock;

    private static Lock redisLock;

    private static RLock rLock;
//
    private static ZkLock zkLock;

    static{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dbLock= context.getBean(DbLock.class);
//        redisLock = context.getBean(RedisLock.class);
//
//
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://192.168.50.20:6379").setDatabase(0);
//        Redisson redisson = (Redisson) Redisson.create(config);
//       rLock = redisson.getLock("redisson_lock");
//
//
       zkLock = new ZkLock("127.0.0.1:2181","stock_zk");

    }


    static class StockThread implements Runnable{

        @Override
        public void run() {

            //lock.lock();

            //dbLock.lock();

            //redisLock.lock();

            //rLock.lock();


            zkLock.lock();

            //扣减库存
            boolean b = new Stock().reduceStock();

            //lock.unlock();
            //dbLock.unlock();

            //redisLock.unlock();

            //rLock.unlock();

            zkLock.unlock();

            if(b){
                System.out.println(Thread.currentThread().getName()+":扣减库存成功！");
            }else{
                System.out.println(Thread.currentThread().getName()+":扣减库存失败！");
            }
        }
    }





    public static void main(String[] args) {
        new Thread(new StockThread(),"用户1").start();
        new Thread(new StockThread(),"用户2").start();
    }
}
