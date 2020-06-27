package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Test7 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)


    val dataRDD = sc.makeRDD(List(1, 2, 3, 4, 5), 2)

    val rdd: RDD[(Int, Iterable[Int])] = dataRDD.groupBy(_%2)
    rdd.collect().foreach{
      case (key,list)=>
        println("key: "+key +" list [ "+list.mkString(",")+"]")

    }
val   x=List((1,2),(3,4))
    x.foreach{case (x,y)=>println(x+"--"+y)}

    sc.stop()
  }
}
