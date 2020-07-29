package com.atguigu.chapter07.super1

object SingleTonDemo {
  def main(args: Array[String]): Unit = {
    val dog = Dog11
    val dog2 = Dog11
    println(dog)
    println(dog2)
  }
}

class Dog11 private() {

}

object Dog11 {
  var singleDog: Dog11 = null

  def apply(): Dog11 = {
    if (singleDog == null) {
      singleDog = new Dog11
    }
    return singleDog
  }
}