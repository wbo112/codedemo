package com.itheima.zkDemo;

public class Stock1 {

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
