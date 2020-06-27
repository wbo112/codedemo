package com.atguigu.wordcount.etl;

import com.atguigu.wordcount.mapperjoin.MJDriver;
import com.atguigu.wordcount.mapperjoin.MJMapper;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.server.jobtracker.JTConfig;

import java.io.File;
import java.io.IOException;

public class ETLDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args=new String[]{"F:\\tmp\\input2","F:\\tmp\\output2"};
        FileUtils.deleteDirectory(new File(args[1]));
        Job job = Job.getInstance(new Configuration());
//        job.getConfiguration().set("mapreduce.map.output.compress","true");
        //job.getConfiguration().set("mapreduce.map.output.compress.codec",);
        job.getConfiguration().set(JTConfig.JT_STAGING_AREA_ROOT,"F:\\tmp\\temp1");
        job.setJarByClass(ETLDriver.class);
        job.setMapperClass(ETLMapper.class);
        job.setNumReduceTasks(0);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        boolean b=job.waitForCompletion(true);
        System.out.println(b);
    }
}
