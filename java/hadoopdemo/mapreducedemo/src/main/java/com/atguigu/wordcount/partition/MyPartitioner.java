package com.atguigu.wordcount.partition;

import com.atguigu.wordcount.flow.FlowBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner  extends Partitioner<Text, FlowBean> {
    @Override
    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {
        String phone=text.toString();

        System.out.println(phone);
        int partition;
        switch (phone.substring(0,3)){
            case "137":
                partition=0;

                break;
            case "138":
                partition=1;
                break;
            case "139":
                partition=2;

                break;
            default:
                partition=3;

        }
        return partition;
    }
}
