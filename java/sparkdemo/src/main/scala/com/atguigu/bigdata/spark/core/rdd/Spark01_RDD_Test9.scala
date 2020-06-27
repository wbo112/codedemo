package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, rdd}
//求分区最大值之和
object Spark01_RDD_Test9 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)


    val dataRDD = sc.makeRDD(List(1, 2, 3, 4, 5,6,7,8), 2)

    val glomRDD: RDD[Array[Int]] = dataRDD.glom()
    val maxRDD: RDD[Int] = glomRDD.map(array => array.max)
    val arr: Array[Int] = maxRDD.collect()
    println(arr.sum)
    sc.stop()
  }
}
