package com.atguigu.chapter02.datatype

object TypeDemo1 {
  def main(args: Array[String]): Unit = {
    var  num1:Int=10
    println("")
    var  isPass=true
    println(isPass.toString)
    sayHi
    sayHi()
  }
  def  sayHi():Unit={
    println("sayHi")
  }
}
