package com.atguigu.chapter05.fundetail

object DetailsRecursive {
  def main(args: Array[String]): Unit = {

  }
  //递归函数必须指明返回类型
  def f1(n:Int):Int={
    if(n==1){
      1
    }else {
      f1(n-1)
    }
  }
}
