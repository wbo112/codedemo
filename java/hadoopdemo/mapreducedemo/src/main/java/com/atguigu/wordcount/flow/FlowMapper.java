package com.atguigu.wordcount.flow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper  extends Mapper<LongWritable,Text, Text,FlowBean> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[]   strs=value.toString().split("\t");
        Text t=new Text(strs[1]);
        FlowBean flow=new FlowBean();
        flow.setDownFlow(1);
        flow.setUpFlow(2);
        flow.setSumFlow(3);
        context.write(t,flow);
    }
}
