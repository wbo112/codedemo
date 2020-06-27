package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Spark01_RDD_Test {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)

    //TODO  --从磁盘File中创建
    val fileRDD: RDD[String] = sc.textFile("input")

//    val  urlRDD: RDD[String] =fileRDD.map(line=>{
//      val datas=line.split("\s")
//      datas(6)
//    })

    println(fileRDD.collect().mkString(","))
    sc.stop()
  }
}
