package com.atguigu.chapter03.inputcon

import scala.io.StdIn

object Demo01 {

  def hi(): Unit = {
    println("hi")
  }

  def main(args: Array[String]): Unit = {
    println("请输入姓名")
    var name = StdIn.readLine
    var age = StdIn.readInt()
    var sal = StdIn.readDouble()
    printf("用户信息, name=%s ,age =%d,sal =%f", name, age, sal)
  }
}

object Cat {
  def sayHi(): Unit = {
    println("")
  }
}
