package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Operator {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    //TODO  --从磁盘File中创建

    //path:读取文件(目录)的路径
    //Spark读取文件时,默认采用的是Hadoop的方式
    //默认是一行一行读取
    //支持通配符的方式
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
    val rdd1 = rdd.map((i: Int) => {
      i * 2
    })
    val rdd2 = rdd.map(_ * 2)
    var rdd3=rdd.map(x=>{
      println("map A " + x)
      x
    })
    var rdd4=rdd3.map(x=>{
      println("map B " + x)
      x
    })
    //rdd2.saveAsTextFile(("outputfileRDD"))
    println(rdd4.collect().mkString(","))
    sc.stop()
  }
}
