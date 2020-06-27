package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

//
object Spark01_RDD_Operator7 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)
    //val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8), 2)
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("", 1), ("cba", 2), ("cba", 1), ("cba", 2)
      , ("hello", 1), ("cba", 3)))
    //第一个参数表示key相同的值的聚合方式
    //第二个参数表示聚合后的分区数量
    val rdd1: RDD[(String, Int)] = rdd.reduceByKey(_ + _)
    println(rdd1.collect().mkString(","))
  }


}