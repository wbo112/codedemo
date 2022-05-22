package com.atguigu.zkdemo;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class DistributeServer {
    ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DistributeServer distributeServer = new DistributeServer();
        String connectionString = "192.168.50.190:2181,192.168.50.191:2181,192.168.50.192:2181";
        int sessionTimeout = 2000;
        distributeServer.connection(connectionString, sessionTimeout);
        String hostname = "server1";
        distributeServer.regist(hostname);
        Thread.currentThread().join();


    }

    private void regist(String hostname) throws InterruptedException, KeeperException {
        zooKeeper.create("/servers/"+hostname, hostname.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("hostname create success");
    }


    private ZooKeeper connection(String connectionString, int sessionTimeout) throws InterruptedException, IOException {

   zooKeeper = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
        while (true)
            if (ZooKeeper.States.CONNECTING == zooKeeper.getState()) {
                Thread.sleep(1000);
            } else {
                break;
            }

        System.out.println(zooKeeper);
        return zooKeeper;
    }
}
