package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Test3 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)


    val dataRDD: RDD[Int] = sc.makeRDD(List(1, 2, 5, 7, 3, 4), 2)
    val rdd = dataRDD.mapPartitionsWithIndex((index, iter) => {
     if(index==1) {

       iter
     }else{
       Nil.iterator
     }

    })

    println(rdd.collect().mkString(","))
    sc.stop()
  }
}
