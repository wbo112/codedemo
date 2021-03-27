package com.itheima.zkDemo;

public class StockMain {
    static class StockThread implements Runnable{

        @Override
        public void run() {
            boolean b = new Stock1().reduceStock();
            if(b){
                System.out.println("减少库存成功");
            }else{
                System.out.println("减少库存失败");
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new StockThread(),"线程1").start();
        new Thread(new StockThread(),"线程2").start();
    }
}
