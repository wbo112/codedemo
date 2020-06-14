package com.atguigu.chapter04.mulfor

object Exercise1 {
  def main(args: Array[String]): Unit = {
    val num=9
    for(i<-1 to num){
      for(j<-1 to i){
        printf("%d * %d = %d  ",j,i,j*i)

      }
      println()
    }
  }
}
