package com.atguigu.chapter07.super1

object SupserSub {
  def main(args: Array[String]): Unit = {
    var person = new Person
    var sun = new Sun
    person = sun
    var sun1 = person.asInstanceOf[Sun]
    sun1.sunName

  }

  def test(p: Person): Unit = {
    if (p.isInstanceOf[Sun]) {
      p.asInstanceOf[Sun].sunName()
    }
    else if (p.isInstanceOf[Man]) {
      p.asInstanceOf[Man].manName()
    }
  }
}

class Person {
  def name(): String = {
    "Person"
  }
}

class Sun extends Person {
  override def name(): String = {
    println("Sun")
    super.name()
  }

  def sunName(): String = {
    "Sun"
  }
}

class Man extends Person {
  override def name(): String = {
    println("Man")
    super.name()
  }

  def manName(): String = {
    "Man"
  }
}