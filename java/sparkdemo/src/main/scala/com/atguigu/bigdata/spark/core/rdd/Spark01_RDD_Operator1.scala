package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
//sample用于从数据集中抽取数据
object Spark01_RDD_Operator1 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9))

    //第一个参数表示数据抽取后是否放回,可以重复抽取
    //true : 抽取后放回
    //false : 抽取后不放回
    //第二个参数表示数据抽取的几率(不放回的场合),重复抽取的次数(放回的场合)
    //第三个参数表示随机数的种子,可以确定数据的抽取
    val dataRDD: RDD[Int] = rdd.sample(false, 0.5)
    println(dataRDD.collect().mkString(","))
    val dataRDD1: RDD[Int] = rdd.sample(true, 0.5)
    println(dataRDD1.collect().mkString(","))
    sc.stop()
  }
}