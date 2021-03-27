package com.itheima.bean;

public class Stock {

    private static int num=1;

    public boolean reduceStock() {
        if(num>0){
            num--;
            return true;
        }else{
            return false;
        }
    }

}
