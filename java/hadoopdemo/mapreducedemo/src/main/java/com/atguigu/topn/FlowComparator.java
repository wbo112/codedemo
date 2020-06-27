package com.atguigu.topn;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlowComparator extends WritableComparator {
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return 0;
    }

    public FlowComparator() {
        super(FlowBean.class,true);
    }
}
