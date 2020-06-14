package com.atguigu.chapter05.myexception

object ScalaException {
  def main(args: Array[String]): Unit = {
    try {
      val a = 1 / 0
    } catch {
      case ex: Exception => println("异常")
    } finally {
      println("finally")
    }

  }
}
