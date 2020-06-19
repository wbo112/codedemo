package com.atguigu.wordcount.partition;

import com.atguigu.wordcount.flow.FlowBean;
import com.atguigu.wordcount.flow.FlowMapper;
import com.atguigu.wordcount.flow.FlowReducer;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.server.jobtracker.JTConfig;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PartitionerDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        FileUtils.deleteDirectory(new File(args[1]));

        Job job= Job.getInstance(new Configuration());
        job.getConfiguration().set(JTConfig.JT_STAGING_AREA_ROOT,"F:\\tmp\\temp1");
        job.setJarByClass(PartitionerDriver.class);
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        job.setOutputKeyClass(Text.class);
        job.setPartitionerClass(MyPartitioner.class);
        job.setOutputValueClass(FlowBean.class);
        job.setNumReduceTasks(10);
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        boolean b=job.waitForCompletion(true);
        System.out.println(b);
    }
}
