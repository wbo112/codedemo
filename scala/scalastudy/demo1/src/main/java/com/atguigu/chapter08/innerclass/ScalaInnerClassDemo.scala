package com.atguigu.chapter08.innerclass

import com.atguigu.chapter08.innerclass

object ScalaInnerClassDemo {
  def main(args: Array[String]): Unit = {
    val outer1: ScalaOutClass = new ScalaOutClass
    val outer2: ScalaOutClass = new ScalaOutClass

    val inner1 = new outer1.ScalaInnerClass
    val inner2 = new outer2.ScalaInnerClass


    val staticInner = new ScalaOutClass.ScalaStaticInnerClass
inner1.info()
    inner1.test(inner2)
  }
}

class ScalaOutClass {
  myouter=> //外部类的别名 看作外部类的一个实例
  var name = "scoot"
  private var sal = 30000.9

  class ScalaInnerClass {

    def info() = {
      println("name =" +myouter.name + "\tage= " + ScalaOutClass.this.sal)
    }
    //这里有一个方法,可以接受ScalaInnerClass实例
    //下面的 ScalaOuterClass#ScalaInnerClass 类型投影的作用就是屏蔽 外部对象对内部类对象的
    //影响
    def test(ic: ScalaOutClass#ScalaInnerClass): Unit = {
      System.out.println("使用了类型投影" + ic)
    }
  }

}

object ScalaOutClass {

  class ScalaStaticInnerClass {


  }

}

