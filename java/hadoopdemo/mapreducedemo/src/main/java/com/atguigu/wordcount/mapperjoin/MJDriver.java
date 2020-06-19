package com.atguigu.wordcount.mapperjoin;


import com.atguigu.wordcount.reducerjoin.OrderBean;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.server.jobtracker.JTConfig;

import java.io.File;
import java.io.IOException;

import static org.apache.hadoop.mapreduce.server.jobtracker.JTConfig.JT_STAGING_AREA_ROOT;

public class MJDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args=new String[]{"F:\\tmp\\input1\\order.txt","F:\\tmp\\output1"};
        FileUtils.deleteDirectory(new File(args[1]));
        Job job = Job.getInstance(new Configuration());


        job.setJarByClass(MJDriver.class);
        job.setMapperClass(MJMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
     job.getConfiguration().set(JTConfig.JT_STAGING_AREA_ROOT,"F:\\tmp\\temp1");
job.addCacheFile(new File("F:\\tmp\\input1\\pd.txt").toURI());
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        boolean b=job.waitForCompletion(true);
        System.out.println(b);
    }
}
