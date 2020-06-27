package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Test8 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)


    val dataRDD = sc.makeRDD(List(1, 2, 3, 4, 5), 2)

    val rdd = dataRDD.filter(num => num % 2==0)
    rdd.collect().foreach(println)
    sc.stop()
  }
}
