package com.itheima.zkDemo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ZkApiDemo {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        //1、创建zookeeper连接
<<<<<<< HEAD
        ZooKeeper zooKeeper = new ZooKeeper("192.168.50.190", 2000, new Watcher() {
=======
        ZooKeeper zooKeeper = new ZooKeeper("192.168.50.229:2181", 2000, new Watcher() {
>>>>>>> 4d186a95142791e5ae4308ca6ffb69d0a767720e

            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("触发了"+watchedEvent.getState()+"操作");
            }
        });
        while(true)
            if (ZooKeeper.States.CONNECTING == zooKeeper.getState()) {
                Thread.sleep(1000);
            }else {
                break;
            }


    //2、创建父节点
        String path = zooKeeper.create("/itheima1", "itheimaValue".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);

        //3、创建子节点
        String path1 = zooKeeper.create("/itheima1/children", "childValue".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path1);

        //4、获取数据
        byte[] data = zooKeeper.getData("/itheima1/children", false, null);
        System.out.println(new String(data));

    //5、修改节点的值
        zooKeeper.setData("/itheima1/children", "childValue1".getBytes(StandardCharsets.UTF_8),-1);


        //6、判断某个节点是否存在
        Stat exists = zooKeeper.exists("/itheima1/children", false);
        System.out.println(exists.getCversion());
        zooKeeper.close();
    }
}
