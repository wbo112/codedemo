package com.atguigu.chapter04.mywhile

object WhileDemo01 {
  def main(args: Array[String]): Unit = {
    var i = 0
    while (i < 10) {
      println("hello ,尚硅谷 " + i)
      i += 1
    }
    println("")
    var j = 0
    do {
      println("hello ,尚硅谷 " + j)
      j += 1
    } while (j < 10)
  }
}
