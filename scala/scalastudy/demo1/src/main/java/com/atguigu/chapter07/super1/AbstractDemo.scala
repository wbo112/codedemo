package com.atguigu.chapter07.super1

object AbstractDemo {

}

abstract  class Animal{
  var name:String
  var  age:Int
  var color:String="black"
  def cry()
}
class Dog extends  Animal{
  override var name: String = _
  override var age: Int = _

  override def cry(): Unit = {
    println("cry")
  }
}