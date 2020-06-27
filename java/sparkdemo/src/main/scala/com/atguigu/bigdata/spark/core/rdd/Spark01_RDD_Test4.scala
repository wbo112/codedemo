package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Test4 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)


    val dataRDD = sc.makeRDD(List(List(1,2),List(3,4)),2)
    val rdd = dataRDD.flatMap(list => list)

    println(rdd.collect().mkString(","))
    sc.stop()
  }
}
