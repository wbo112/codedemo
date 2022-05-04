package com.itheima.zkDemo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class ZookeeperDemo {
    private static String connectionString="192.168.50.190:2181,192.168.50.191:2181,192.168.50.192:2181";
    private static int sessionTimeout=2000;
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zookeeper = createZookeeper();
        getChildren(zookeeper,"");
    }

    private static ZooKeeper createZookeeper() throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
        while(true)
            if (ZooKeeper.States.CONNECTING == zooKeeper.getState()) {
                Thread.sleep(1000);
            }else {
                break;
            }

        System.out.println(zooKeeper);
        return zooKeeper;
    }
    public static void getChildren( ZooKeeper zooKeeper,String path ) throws InterruptedException, KeeperException {
        System.out.println("zookeeper path = "+path);
        path=path+"";
        List<String> children = zooKeeper.getChildren(path, true);
        String finalPath = path;
        children.stream().forEach(child->{
            try {
                getChildren(zooKeeper, finalPath +child);



            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

    }
}
