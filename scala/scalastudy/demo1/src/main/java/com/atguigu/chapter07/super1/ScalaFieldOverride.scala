package com.atguigu.chapter07.super1

object ScalaFieldOverride {
  def main(args: Array[String]): Unit = {
    val obja: A = new B
    val objb: B = new B
    println("obja.age=" + obja.age + "\tobjb.age=" + objb.age)
  }
}

class A {
  val age: Int = 10

}

class B extends A {
  //覆写属性只能val 属性
  override val age: Int = 20
}
