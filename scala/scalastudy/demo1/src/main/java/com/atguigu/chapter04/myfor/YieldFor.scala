package com.atguigu.chapter04.myfor

object YieldFor {
  def main(args: Array[String]): Unit = {
    var res=for(i<- 1 to 10) yield  i*2
    println(res)
    val  res1=for(i<-  1 to 10) yield{
      if(i%2==0){
        i
      }else{
        "不是偶数"
      }
    }
    println(res1)



    for{i<-1 to 3
        j=i*2}{
      println(i+" "+j)
    }

    println()
    for (i <- 1 to 3; j = i*2) {
      println(i + " "+j)
    }
    println()
    for (i <- 1 to 3; j <- 1 to 3) {
      println(i + "  " + j)
    }

    println()
    for(i<- Range(1,10,2)){
      println("i  = "+i)
    }
  }
}
