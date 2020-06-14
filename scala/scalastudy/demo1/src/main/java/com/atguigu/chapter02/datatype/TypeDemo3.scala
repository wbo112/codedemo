package com.atguigu.chapter02.datatype

object TypeDemo3 {
  def main(args: Array[String]): Unit = {
    println("long的最大值" + Long.MaxValue + "~" + Long.MinValue)
    var i = 10
    var j = 101
    var e = 9223323232422325l

    var n1 = 10
    var n2: Int = 10
    var n3 = n1 + n2
    println(n3.getClass)
    //var s1:Short=10+20
    var d1 = 1.2
    var s1 = d1 + ""
    println(s1.getClass)
    var s2:String="1.2"
    var d2=s2.toDouble
    println(d2.getClass)
var   s4="12.5"
    println(s4.toInt)

  }
}
