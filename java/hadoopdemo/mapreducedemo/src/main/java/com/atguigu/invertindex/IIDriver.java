package com.atguigu.invertindex;

import com.atguigu.topn.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.server.jobtracker.JTConfig;

import java.io.IOException;

public class IIDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        args = new String[]{"F:\\tmp\\input6", "F:\\tmp\\output6_1", "F:\\tmp\\output6_2"};
        Job job = Job.getInstance(new Configuration());
        job.getConfiguration().set(JTConfig.JT_STAGING_AREA_ROOT, "F:\\tmp\\temp1");
        job.setJarByClass(IIDriver.class);
        job.setMapperClass(IIMapper1.class);
        job.setReducerClass(IIReducer1.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        boolean b = job.waitForCompletion(true);
        if (b) {
            Job job1 = Job.getInstance(new Configuration());
            job1.getConfiguration().set(JTConfig.JT_STAGING_AREA_ROOT, "F:\\tmp\\temp1");
            job1.setJarByClass(IIDriver.class);
            job1.setMapperClass(IIMapper2.class);
            job1.setReducerClass(IIReducer2.class);

            job1.setMapOutputKeyClass(Text.class);
            job1.setMapOutputValueClass(Text.class);
            job1.setOutputKeyClass(Text.class);
            job1.setOutputValueClass(Text.class);
            FileInputFormat.setInputPaths(job1, new Path(args[1]));
            FileOutputFormat.setOutputPath(job1, new Path(args[2]));
            boolean b1 = job1.waitForCompletion(true);
            System.out.println(b1);
        }
    }
}
