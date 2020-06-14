package com.atguigu.chapter05.fundetail

object LazyDemo1 {
  def main(args: Array[String]): Unit = {
    lazy  val res=sum(1,2)
    println("----------------------")
    println("res = "+res)
  }
  def sum(n1:Int,n2:Int):Int={
    println("sum() 执行了")
    return  n1+n2
  }
}
