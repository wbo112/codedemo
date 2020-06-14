package com.atguigu.chapter02.datatype


object TypeDemo02 {
  def main(args: Array[String]): Unit = {
//    println(sayHello)

    var  num=1.2
    var num2=1.7f
    num2=num.toFloat
    println(num2)

  }
  //Nothing 做返回值，表明该方法没有正常的返回值
  def sayHello:Nothing={
    throw new Exception("抛出异常")
  }
}


