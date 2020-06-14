package com.atguigu.chapter06.constructor

object ConDemo02 {
  def main(args: Array[String]): Unit = {
    val bb=new BB
    val bb1=new BB("b")
    val cc=new CC()
    println(cc.name)
    val  dd=new DD()
    println(dd.name)

  }
}
class AA{
  println("AA")
}
class BB extends AA{
  def  this(name:String){
    this
    println("BB Constructor")
  }
}
//参数用val,var修饰，可以在外面访问
class CC private(val name:String) extends AA{
  println(name)
  def  this(){
    this("cc")
    println("CC Constructor")
  }
}
//参数用val,var修饰，可以在外面访问
class DD private(var name:String) extends AA{
  println(name)
  def  this(){
    this("dd")
    println("DD Constructor")
  }
}