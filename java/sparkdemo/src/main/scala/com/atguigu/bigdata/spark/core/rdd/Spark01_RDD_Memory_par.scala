package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory_par {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    //TODO  --从内存中创建RDD

    val list = List(1, 2, 3, 4)
    val rdd: RDD[Int] = sc.parallelize(list)
    rdd.collect().foreach(println)
    //1、makeRDD 第一个参数：数据源
    //2、makeRDD 第二个参数:并行度
    val rdd1: RDD[Int] = sc.makeRDD(list)
    rdd.saveAsTextFile("output")
    println(rdd1.collect().mkString(","))
    sc.stop()
  }
}
