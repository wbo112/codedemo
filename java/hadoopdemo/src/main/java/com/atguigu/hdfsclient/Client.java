package com.atguigu.hdfsclient;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.hadoop.fs.FileSystem.*;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Configuration  configuration=new Configuration();
//        FileSystem fileSystem = get(URI.create("hdfs://192.168.66.137:9000"), configuration, "aiguigu");
//        fileSystem.copyToLocalFile(new Path("/output"),new Path("F:\\code\\test"));
//        fileSystem.close();

        //rename();
        //delete();
        //append();
    }
    public  static void rename() throws IOException, InterruptedException {
        FileSystem fileSystem=FileSystem.get(URI.create("hdfs://192.168.66.137:9000"),new Configuration(),"atguigu");
        boolean rename = fileSystem.rename(new Path("/wcinput"), new Path("/test2"));
        fileSystem.close();
    }
    public  static void delete() throws IOException, InterruptedException {
        FileSystem fileSystem=FileSystem.get(URI.create("hdfs://192.168.66.137:9000"),new Configuration(),"atguigu");
        boolean delete = fileSystem.delete(new Path("/test2"),true);
        fileSystem.close();
    }
    public static void append() throws IOException, InterruptedException {
        FileSystem fileSystem=FileSystem.get(URI.create("hdfs://192.168.66.137:9000"),new Configuration(),"atguigu");

        IOUtils.copyBytes(Files.newInputStream(Paths.get("F:\\BaiduNetdiskDownload\\尚硅谷Kubernetes教程\\重要！！！镜像软件使用说明(1).txt")),fileSystem.append(new Path("/output/part-r-00000")),1024,true);
    }
}
