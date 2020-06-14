package com.atguigu.chapter05.fundetail

object VarParameters {
  def main(args: Array[String]): Unit = {
    println(sum(1,2,3,4,5,6))
  }

  def sum(n1:Int,args:Int*):Int={
    println(args.getClass)
    println("args.length "+args.length)
    var sum=n1
    for(item<-args){
      sum+=item
    }
    return sum
  }
}
