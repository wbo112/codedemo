package com.atguigu.wordcount.groupingcomparator;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderBean implements WritableComparable<OrderBean> {
   private String orderId;
   private  String productId;
   private double price;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(OrderBean o) {
        int orderCom=this.orderId.compareTo(o.orderId);
        if(orderCom!=0){
            return orderCom;
        }
        int priceCom=Double.compare(this.price,o.price);

        return priceCom;
    }

    @Override
    public void write(DataOutput out) throws IOException {
out.writeUTF(orderId);
out.writeUTF(productId);
out.writeDouble(price);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
this.orderId=in.readUTF();
this.productId=in.readUTF();
this.price=in.readDouble();
    }
}
