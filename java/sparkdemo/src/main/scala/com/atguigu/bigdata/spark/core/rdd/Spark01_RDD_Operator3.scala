package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

//coalesce 当数据过滤后,发现数据不够均匀,那么可以缩减分区

object Spark01_RDD_Operator3 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 1, 1, 1, 2, 2, 2, 2), 8)
    val filterRDD: RDD[Int] = rdd.filter(num => num % 2 == 0)
    //val coalesceRDD: RDD[Int] = filterRDD.coalesce(1)
    //TODO 数据分区不合理,也可以缩减分区
    //coalesce 第一个参数表示缩减分区后的分区数量
    //coalesce 第二个参数表示分区改变时,是否打乱重新组合,默认不打乱
    val coalesceRDD: RDD[Int] = filterRDD.coalesce(3,true)

    //TODO  缩减分区 :coalesce
    //TODO 扩大分区: repartition


    coalesceRDD.saveAsTextFile("output")
    sc.stop()
  }
}