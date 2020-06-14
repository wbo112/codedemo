package com.atguigu.chapter06.constructor

object ConDemo01 {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("A", 10)
val p2=new Person("B")
  }

}

class Person(inName: String, inAge: Int) {
  var name: String = inName
  var age: Int = inAge
  println("~~~~~~~~~~~~~~~~~~~~")
  println("age =" + age)

  override def toString: String = {
    "name= " + this.name + "\tage=" + this.age
  }

  def this(inName: String) {
    this(inName, 100)
  }

}
