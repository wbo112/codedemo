package com.atguigu.topn;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text, FlowBean, Text> {


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split("\t+");
        Text text = new Text(fields[0]);
        FlowBean flowBean = new FlowBean();
        flowBean.setDownFlow(Long.parseLong(fields[1]));
        flowBean.setUpFlow(Long.parseLong(fields[2]));
        context.write(flowBean, text);
    }
}
