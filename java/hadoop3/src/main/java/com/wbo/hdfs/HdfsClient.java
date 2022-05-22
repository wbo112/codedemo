package com.wbo.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class HdfsClient {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        //upLoadFile();
        fileList();
    }

    public static void mkdir() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("hdfs://192.168.68.120:9000");
        Configuration configuration = new Configuration();
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        String user = "root";
        FileSystem fileSystem = FileSystem.get(uri, configuration, user);
        boolean suc = fileSystem.mkdirs(new Path("/test/demo"));
        System.out.println(suc);
        fileSystem.close();
    }

    public static void upLoadFile() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("hdfs://192.168.68.120:9000");
        Configuration configuration = new Configuration();
        //configuration.set("","");
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        String user = "root";
        FileSystem fileSystem = FileSystem.get(uri, configuration, user);
        fileSystem.copyFromLocalFile(new Path("src/main/resources/a.txt"), new Path("/test/demo/b.txt"));

        fileSystem.close();
    }

    public static void fileList() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("hdfs://192.168.68.120:9000");
        Configuration configuration = new Configuration();
        //configuration.set("","");
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        String user = "root";
        FileSystem fileSystem = FileSystem.get(uri, configuration, user);
        //RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("/"),true);//遍历文件
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/"));
        Arrays.stream(fileStatuses).forEach(fileStatus -> System.out.println(fileStatus.isFile() + "___" + fileStatus.getPath()));

        fileSystem.close();
    }
}
