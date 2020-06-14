package com.atguigu.chapter04.mycontinue

object ContinueDemo {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10 if (i != 2 && i != 3)) {
      println("i=" + i)
    }
  }
}
