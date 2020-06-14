package com.atguigu.chapter05.myexception

object ThrowDemo {
  def main(args: Array[String]): Unit = {
    try{
      val res=test()
      println(res.toString)
    }catch {
      case ex:Exception=>println("捕获到异常 "+ex.getMessage)
    }

    println("ok")
  }
  def test():Nothing={
    throw new Exception("异常出现")
  }
}
