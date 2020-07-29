package com.atguigu.chapter09.`implicit`

object ImplicitDemo {
  def main(args: Array[String]): Unit = {
   implicit  def f(d:Double):Int={
     d.toInt
   }
    val num:Int =3.5
  }
}
