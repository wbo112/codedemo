package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

//
object Spark01_RDD_Operator6 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)
    //val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8), 2)
    val rdd: RDD[(String, String)] = sc.makeRDD(List(("cba", "消息1"), ("cba", "消息1"), ("cba", "消息1"), ("cba", "消息1")
      , ("cba", "消息1"), ("cba", "消息1")))

    val rdd1: RDD[(String, String)] = rdd.partitionBy(new MyPartitioner(3))
    val rdd2 = rdd1.mapPartitionsWithIndex((index, datas) => datas.map(data => (index, data)))
    println(rdd2.collect().mkString(","))
    sc.stop()
  }

  class MyPartitioner(num: Int) extends Partitioner {
    override def numPartitions: Int = num

    override def getPartition(key: Any): Int = {
      key match {
        case "nba" => 0
        case _ => 1
      }
    }
  }

}