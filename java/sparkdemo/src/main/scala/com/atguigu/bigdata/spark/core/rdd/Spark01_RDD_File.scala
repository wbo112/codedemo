package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_File {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    //TODO  --从磁盘File中创建

    //path:读取文件(目录)的路径
    //Spark读取文件时,默认采用的是Hadoop的方式
    //默认是一行一行读取
    //支持通配符的方式
    val fileRDD: RDD[String] = sc.textFile("input")
    fileRDD.saveAsTextFile(("outputfileRDD"))
    println(fileRDD.collect().mkString(","))
    sc.stop()
  }
}
