package com.atguigu.bigdata.spark.core.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {
  def main(args: Array[String]): Unit = {
    //TODO 1、准备Spark环境
    //setMaster:设定Spark环境的位置
    //local表示本地环境
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    //TODO 2、建立和Spark的连接
    val context = new SparkContext(sparkConf)

    //TODO 3、实现业务操作


    //TODO 3.1  读取指定目录下的文件
    val fiLeRDD: RDD[String] = context.textFile("input")
    //TODO 3.2将读取的内容进行扁平化操作，切分单词
    val wordRDD: RDD[String] = fiLeRDD.flatMap(_.split(" "))
    //    //TODO 3.3  将分词后的数据进行分组(单词)
    //    val groupRDD:RDD[(String,Iterable[String])] = wordRDD.groupBy(word => word)
    //
    //
    //    //TODO 3.4 将分组后的数据进行聚合
    //    val mapRDD:RDD[(String,Int)] = groupRDD.map {
    //      case (word, iter) => {
    //        (word, iter.size)
    //      }
    //    }
    //
    //
    //    //TODO 3.5将聚合的数据打印到控制台
    //
    //    val wordCountArray:Array[(String,Int)]=mapRDD.collect()


    //TODO 3.3 将分词后的数据进行结构转化
    val mapRDD: RDD[(String, Int)] = wordRDD.map(word => (word, 1))

    //TODO 3.4将转化后的数据根据单词进行分组聚合
    val wordToSumRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)
    println(wordToSumRDD.collect().mkString(","))
    //TODO 4、释放连接
    context.stop()
  }
}
