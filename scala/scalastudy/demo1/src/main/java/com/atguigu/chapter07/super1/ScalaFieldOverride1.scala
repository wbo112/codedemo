package com.atguigu.chapter07.super1

object ScalaFieldOverride1 {
  def main(args: Array[String]): Unit = {
    val obja: AA = new BB
    val objb: BB = new BB
    println("obja.age=" + obja.sal + "\tobjb.age=" + objb.sal)
  }
}
class AA{
  def sal():Int={
    return 10
  }
}
class BB extends  AA{
  override val  sal:Int=0
}