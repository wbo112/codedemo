package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

//
object Spark01_RDD_Operator5 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4), 2)
    val rdd1: RDD[Int] = sc.makeRDD(List(5,6,7,8), 2)
    //TODO 数据合并 分区也会合并
    val rdd3: RDD[Int] = rdd.union(rdd1)
    println(rdd3.collect().mkString(","))
      //TODO 交集   保留最大分区数，数据打乱重组
    val rdd4: RDD[Int] =rdd.intersection(rdd1)
    println(rdd4.collect().mkString(","))
    //TODO 差集 数据被打乱重组 shuffle
    val rdd5: RDD[Int] = rdd.subtract(rdd1)
    println(rdd5.collect().mkString(","))
//TODO   拉链:分区数不变
    //TODO 分区要一致,每个分区的数量需要一致
    val rdd6: RDD[(Int, Int)] = rdd.zip(rdd1)
    println(rdd6.collect().mkString(","))

    sc.stop()
  }
}