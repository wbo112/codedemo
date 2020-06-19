package com.atguigu.wordcount.reducerjoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class RJMapper extends Mapper<LongWritable, Text, OrderBean, NullWritable> {
    String filename;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        FileSplit fileSplit = (FileSplit) context.getInputSplit();
        filename = fileSplit.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split("\t");
        OrderBean orderBean = new OrderBean();
        if ("order.txt".equals(filename)) {

            orderBean.setId(fields[0]);
            orderBean.setPid(fields[1]);
            orderBean.setAmount(Integer.parseInt(fields[2]));
            orderBean.setPname("");
        } else {

            orderBean.setId("");
            orderBean.setPid(fields[0]);
            orderBean.setAmount(0);
            orderBean.setPname(fields[1]);
        }
        context.write(orderBean, NullWritable.get());
    }
}
