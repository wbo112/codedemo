package com.atguigu.chapter04.myfor

object ForGuard {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 3 if i != 2) {
      print(i + " ")
    }
    println()
    for (i <- 1 to 3; j = 4 - i) {
      print(j + " ")
    }
    println()
    for (i <- 1 to 3; j <- 1 to 3) {
      println(i + "  " + j)
    }
  }
}
