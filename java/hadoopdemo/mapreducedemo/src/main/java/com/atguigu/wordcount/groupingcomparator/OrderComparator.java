package com.atguigu.wordcount.groupingcomparator;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class OrderComparator  extends WritableComparator {
    public OrderComparator() {
        super(OrderBean.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
       OrderBean oa= (OrderBean) a;
       OrderBean ob= (OrderBean) b;
        return oa.compareTo(ob);
    }
}
