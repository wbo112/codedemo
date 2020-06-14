package com.atguigu.chapter04.myfor

object ForDemo01 {
  def main(args: Array[String]): Unit = {
    var start = 1
    var end = 10
    for (i <- start to end) {
      println("你好，尚硅谷 " + i)
    }
    var list = List("hello", 1, "abc")
    for (item <- list) {
      println(item)
    }

    var start1 = 1;
    var end1 = 11
    for (i <- start until end1) {
      println("hello  ,until " + i)
    }
  }
}
