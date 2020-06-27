package com.atguigu.friend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FFMapper2 extends Mapper<LongWritable,Text,Text, Text> {
    private Text k=new Text();
    private Text v=new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] split = value.toString().split("\t");
 v.set(split[0]);
 String[]  m=split[1].split(",");
   for(int i=0;i<m.length;i++){
       for (int j = i+1; j < m.length; j++) {
           k.set(m[i]+"-"+m[j]);
           context.write(k,v);
       }
   }
    }
}
