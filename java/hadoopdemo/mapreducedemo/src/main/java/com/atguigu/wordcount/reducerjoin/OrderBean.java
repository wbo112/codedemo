package com.atguigu.wordcount.reducerjoin;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderBean implements WritableComparable<OrderBean> {
    private String pname;
private String pid;
private int amount;
private String id;

    @Override
    public int compareTo(OrderBean o) {
        int compare=pid.compareTo(o.pid);
        if(compare==0){
            return o.pname.compareTo(pname);
        }else{
            return compare;
        }

    }

    @Override
    public void write(DataOutput out) throws IOException {
out.writeUTF(id);
out.writeUTF(pname);
out.writeUTF(pid);
out.writeInt(amount);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
id=in.readUTF();
pname=in.readUTF();
pid=in.readUTF();
        amount=in.readInt();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
