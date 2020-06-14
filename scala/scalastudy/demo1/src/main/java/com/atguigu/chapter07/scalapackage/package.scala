package com.atguigu.chapter07

/**
 * 包对象,可以定义变量和函数，只能在同名包中使用
 */
package object scala {
val  name="abc"
  def say(name:String):Unit={
    println(name)
  }
}
package  scala{
  object   Test001{
    def main(args: Array[String]): Unit = {
      println(name)
      say("abc")
    }
  }
}
package scala1{
  object  Test002{
    def test(args: Array[String]): Unit = {
     // println(name)
    }
  }
}