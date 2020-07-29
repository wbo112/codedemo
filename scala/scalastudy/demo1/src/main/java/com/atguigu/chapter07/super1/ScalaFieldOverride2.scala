package com.atguigu.chapter07.super1

object ScalaFieldOverride2 {

}

abstract class A1 {
  var name: String //抽象
  //var age: Int = 10// var不能重写
}

class B1 extends A1 {
  override var name: String = _//覆写抽象属性,override可以省略
  //override var age:Int //var不能重写
}