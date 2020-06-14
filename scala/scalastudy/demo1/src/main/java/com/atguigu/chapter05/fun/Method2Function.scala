package com.atguigu.chapter05.fun

object Method2Function {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    println(dog.sum(10, 20))


    val f1 = dog.sum _
    println("f1= " + f1)
    println("f1=" + f1(50, 60))
    val f2 = (n1: Int, n2: Int) => {
      n1 + n2
    }
    println("f2= "+f2)

  }
}

class Dog {
  def sum(n1: Int, n2: Int): Int = {
    n1 + n2
  }

}