package com.atguigu.chapter06.oop

object CatDemo {
  def main(args: Array[String]): Unit = {
    val  cat=new Cat
    cat.name="小白"
    cat.age=10
    cat.color="白色"
    println("ok")
    printf("\n小猫的信息如下:%s %d %s",cat.name,cat.age,cat.color)
    val dog=new Dog

    println(dog.name)
  }
}
class  Cat{
  var  name:String=""
  var age:Int=_ //_表示给age一个默认的值 如果是Int  默认值就是0
  var  color:String =_  //给color 默认值 如果是String，默认值就是”“
}
class Dog{
  var name=null
}