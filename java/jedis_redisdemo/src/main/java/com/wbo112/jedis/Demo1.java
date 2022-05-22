package com.wbo112.jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Demo1 {
    /**
     * 需要修改redis.conf配置文件参数
     * 注释掉bind 127.0.0.1 -::1  或者修改成外网可以访问的IP
     * protected-mode no
     * ======
     * 关闭redis服务器防火墙
     */
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.50.20",6379);
        String value = jedis.ping();
        System.out.println(value);

        //获取所有key
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);



    }
}
