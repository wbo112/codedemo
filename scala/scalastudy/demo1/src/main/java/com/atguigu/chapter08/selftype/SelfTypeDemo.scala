package com.atguigu.chapter08.selftype

object SelfTypeDemo {
  def main(args: Array[String]): Unit = {

  }
}

trait  Logger{
  this:Exception=>
  def log():Unit={
    println(getMessage)
  }


}