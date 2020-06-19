package com.atguigu.wordcount.reducerjoin;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapreduce.RecordWriter;

public class RJComparator extends WritableComparator {
    public RJComparator() {
super(OrderBean.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        OrderBean orderBeana = (OrderBean) a;
        OrderBean orderBeanb = (OrderBean) b;
        return orderBeana.getPid().compareTo(orderBeanb.getPid());
    }
}
