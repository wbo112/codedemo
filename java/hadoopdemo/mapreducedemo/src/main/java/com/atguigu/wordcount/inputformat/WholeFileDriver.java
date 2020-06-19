package com.atguigu.wordcount.inputformat;

import com.atguigu.wordcount.flow.FlowBean;
import com.atguigu.wordcount.flow.FlowDriver;
import com.atguigu.wordcount.flow.FlowMapper;
import com.atguigu.wordcount.flow.FlowReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.server.jobtracker.JTConfig;

import java.io.IOException;

public class WholeFileDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job= Job.getInstance(new Configuration());
        job.getConfiguration().set(JTConfig.JT_STAGING_AREA_ROOT,"F:\\tmp\\temp1");
        job.setJarByClass(WholeFileDriver.class);
        //job.setMapperClass(FlowMapper.class);
        //job.setReducerClass(FlowReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(BytesWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(BytesWritable.class);
        job.setInputFormatClass(WholeFileInputFormat.class);
        job.setNumReduceTasks(10);
        FileInputFormat.setInputPaths(job, new Path("F:\\tmp\\input"));
        FileOutputFormat.setOutputPath(job, new Path("F:\\tmp\\output"));
        boolean b=job.waitForCompletion(true);
        System.out.println(b);
    }
}
