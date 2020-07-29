package com.atguigu.chapter07.exercise

object Exercise1 {
  def main(args: Array[String]): Unit = {
println(Suits)
  }
}

object  Suits extends Enumeration{
  //type Suits=Value
  val Spade=Value("a")
  val Club=Value("b")
  val Heart=Value("c")


  val Diamond=Value("d")
  override def toString(): String = values.mkString(",")
}