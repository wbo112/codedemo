package com.atguigu.wordcount.outputformat;


import org.apache.commons.io.IOUtils;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MyRecordWriter extends RecordWriter<LongWritable, Text> {
    FSDataOutputStream atguigu;
    FSDataOutputStream other;

    // 初始化方法
    public void initialinze(TaskAttemptContext context) throws IOException {
        String outdir = context.getConfiguration().get(FileOutputFormat.OUTDIR);
        FileSystem fileSystem = FileSystem.get(context.getConfiguration());
        atguigu = fileSystem.create(new Path(FileOutputFormat.OUTDIR + "/atguigu.txt"));
        other = fileSystem.create(new Path(FileOutputFormat.OUTDIR + "/other.txt"));
    }

    //将KV写出
    @Override
    public void write(LongWritable key, Text value) throws IOException, InterruptedException {
        String out = value.toString();
        if (out.indexOf("atguigu") != -1) {
            atguigu.write(out.getBytes());
        } else {
            other.write(out.getBytes());
        }
    }

    @Override
    public void close(TaskAttemptContext context) throws IOException, InterruptedException {
        IOUtils.closeQuietly(atguigu);
        IOUtils.closeQuietly(other);
    }
}
