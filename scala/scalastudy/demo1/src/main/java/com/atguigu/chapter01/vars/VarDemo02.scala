package com.atguigu.chapter01.vars

object VarDemo02 {
  def main(args: Array[String]): Unit = {
    //类型推导
    var num = 10 //类型为Int


    println(num.isInstanceOf[Int])
    var age = 10 //var  变量的值是可以改变的
    age = 30

    val num2 = 30 //val  修饰的变量的值是不可以改变的
    val dog = new Dog
    dog.age = 10
  }
}

class Dog {
  var age: Int = _
  var name: String = ""

}