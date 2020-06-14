package com.atguigu.chapter05.fundetail

object Details {
  def main(args: Array[String]): Unit = {
    println(getSum(1, 2))
    println(getSum1(1, 2))
    println(getSum2(1, 2))
  }

  //代码中写了return  必须写名返回类型
  def getSum(n1: Int, n2: Int): Int = {
    return n1 + n2
  }

  //返回类型什么都没写，即使return也没有返回值
  def getSum1(n1: Int, n2: Int) {
    return n1 + n2
  }

  def getSum2(n1: Int, n2: Int): Unit = {
    return n1 + n2
  }
}
