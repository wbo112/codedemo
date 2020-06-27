package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

//根据单词首字母分组
object Spark01_RDD_Test10 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc: SparkContext = new SparkContext(sparkConf)


    val dataRDD = sc.makeRDD(List("Hello","hive","hbase","Hadoop"), 2)
    val groupbyRDD: RDD[(Char, Iterable[String])] = dataRDD.groupBy(word => {
      //word.substring(0,1)
      //隐式转换
      word(0)
    })

    sc.stop()
  }
}
