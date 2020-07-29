package com.atguigu.chapter08.mixin

object MixInDemo01 {
  def main(args: Array[String]): Unit = {
val  oracleDB=new OracleDB with Operate
    oracleDB.insert(100)
    
  }
}
trait   Operate{
  def insert(id:Int):Unit={

    println("插入数据= "+id)
  }
}

class OracleDB{

}
abstract  class Mysql{

}
