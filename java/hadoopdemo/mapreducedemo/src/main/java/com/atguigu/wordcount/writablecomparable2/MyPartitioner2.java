package com.atguigu.wordcount.writablecomparable2;

import com.atguigu.wordcount.writablecomparable.FlowBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner2 extends Partitioner<Text, FlowBean> {
    @Override
    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {
        String phone=text.toString();
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
