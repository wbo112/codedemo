package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Test1 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)

    //TODO  --从磁盘File中创建
    val dataRDD: RDD[Int] = sc.makeRDD(List(1, 2, 5, 7, 3, 4), 2)
    //获取每个分区的最大值
    val rdd: RDD[Int] = dataRDD.mapPartitions(iter => {
      List(iter.max).iterator
    })

    println(rdd.collect().mkString(","))
    sc.stop()
  }
}
