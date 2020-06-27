package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

//sortBy  排序
object Spark01_RDD_Operator4 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 1, 1, 1, 2, 2, 2, 2), 8)
    val filterRDD: RDD[Int] = rdd.filter(num => num % 2 == 0)
    //val coalesceRDD: RDD[Int] = filterRDD.coalesce(1)
    //默认升序排列,第二个参数可以指定排序方式

    //  val sortRDD: RDD[Int] = rdd.sortBy(num => num)





    val sortRDD: RDD[Int] = rdd.sortBy(num => num,false)
    println(sortRDD.collect().mkString(","))

    sc.stop()
  }
}