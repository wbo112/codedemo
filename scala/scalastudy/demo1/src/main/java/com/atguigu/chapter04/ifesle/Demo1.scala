package com.atguigu.chapter04.ifesle

object Demo1 {
  def main(args: Array[String]): Unit = {
    val  age=10
    val  res=if(age<20){
      println("ok")
      "hello world!"
    }else{
      7
    }
    println(res.getClass)
  }
}
