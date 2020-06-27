package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Test5 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)


    val dataRDD = sc.makeRDD(List(List(1,2),3,List(4,5)),2)
    val rdd = dataRDD.flatMap(data=>{
      data match{
        case list:List[_]=>list
        case d=>List(d)
        //case _
      }
    })

    println(rdd.collect().mkString(","))
    sc.stop()
  }
}
