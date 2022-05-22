package com.wbo112.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SecKill_Redis {
    public static void main(String[] args) {
        String userId=new Random().nextInt(10000)+"";
        String prodId="1";
        doSecKill(userId,prodId);
    }
    public static boolean doSecKill(String uid,String prodid){

        if(Objects.isNull(uid)||Objects.isNull(prodid)){
            return false;

        }
        Jedis jedis=new Jedis("192.168.50.20",6379);


        //库存key
        String kcKey="sk:"+prodid+":qt";

        //秒杀成功用户key
        String userKey="sk:"+prodid+":user";
        jedis.watch(kcKey);
        String kc=jedis.get(kcKey);
        if(Objects.isNull(kc)){
            System.out.println("秒杀还没开始,请等待");
            jedis.close();
            return false;
        }

        //判断用户是否重复秒杀
        if (jedis.sismember(userKey,uid)) {
            System.out.println("已经秒杀成功,不能重复秒杀");
            jedis.close();
            return false;
        }
        //判断库存
        if(Integer.parseInt(kc)<=0){
            System.out.println("秒杀已经结束");
            jedis.close();
            return false;

        }
        //开始秒杀
        //库存-1
        Transaction multi = jedis.multi();
        multi.decr(kcKey);
        multi.sadd(userKey,uid);
        List<Object> result = multi.exec();
        if(result==null||result.isEmpty()){
            jedis.close();
            return false;
        }
//        jedis.decr(kcKey);
//        //把秒杀成功的用户添加到清单里面
//        jedis.sadd(userKey,uid);
        System.out.println("秒杀成功");
        return true;
    }
}
