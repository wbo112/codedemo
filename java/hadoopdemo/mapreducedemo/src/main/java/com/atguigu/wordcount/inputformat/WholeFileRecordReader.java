package com.atguigu.wordcount.inputformat;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;

import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class WholeFileRecordReader extends org.apache.hadoop.mapreduce.RecordReader<Text, BytesWritable> {
    private boolean notRead = true;

    private Text key;
    private BytesWritable value;
    private FileSplit fileSplit;
    private FSDataInputStream fsDataInputStream;

    //初始化时调用
    @Override
    public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
        //转换切片类型到文件类型
        fileSplit = (FileSplit) split;
        Path path = fileSplit.getPath();
        FileSystem fileSystem = path.getFileSystem(context.getConfiguration());
        fsDataInputStream = fileSystem.open(path);

    }

    //读取下一步KV值，如果读到了返回true
    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        if (notRead) {
            key = new Text(fileSplit.getPath().toString());
            byte[] bytes = new byte[(int) fileSplit.getLength()];
            fsDataInputStream.read(bytes);
            value = new BytesWritable(bytes);

            notRead = false;
            return true;
        }
        return false;
    }

    //获取当前读到的key
    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return key;
    }

    //获取当前读到的value
    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    //当前数据读取的进度
    @Override
    public float getProgress() throws IOException, InterruptedException {
        return notRead ? 0 : 1;
    }

    @Override
    public void close() throws IOException {
        IOUtils.closeStream(fsDataInputStream);
    }
}
