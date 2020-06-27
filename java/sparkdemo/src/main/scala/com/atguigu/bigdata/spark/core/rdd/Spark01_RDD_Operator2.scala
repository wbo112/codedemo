package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

//distinct 从数据集中去重
object Spark01_RDD_Operator2 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3,5,3,2, 4, 5, 6, 7, 8, 9))
    val disRDD: RDD[Int] = rdd.distinct()
    println(disRDD.collect().mkString(","))
    sc.stop()
  }
}