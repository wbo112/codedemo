package com.atguigu.chapter05.myexception



object ThrowComment {
  def main(args: Array[String]): Unit = {
    f11()
    println("ok")
  }

@throws(classOf[NumberFormatException])
  def f11(): Unit ={
"abc".toInt
  }
}
