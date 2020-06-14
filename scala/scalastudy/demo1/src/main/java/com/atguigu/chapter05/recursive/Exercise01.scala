package com.atguigu.chapter05.recursive

object Exercise01 {
  def main(args: Array[String]): Unit = {
    println("fbn = "+fbn(10))
  }
  def fbn(n:Int):Int={
    if(n==1||n==2){
      1
    }else{
      fbn(n-1)+fbn(n-2)
    }
  }
}
