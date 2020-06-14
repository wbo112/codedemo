package com.atguigu.chapter06.exercise

object Exercise01 {
  def main(args: Array[String]): Unit = {
    val  n=3
    val res1=(0 to n).reverse
    println(res1)

    //将res1的每个元素一次遍历，传递给println
    res1.foreach(println)
    res1.foreach(myShow)
  }
  def myShow(n:Int):Unit={
    println(n)
  }
}
