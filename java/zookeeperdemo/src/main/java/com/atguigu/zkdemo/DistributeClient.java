package com.atguigu.zkdemo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class DistributeClient {
    ZooKeeper zooKeeper;
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
