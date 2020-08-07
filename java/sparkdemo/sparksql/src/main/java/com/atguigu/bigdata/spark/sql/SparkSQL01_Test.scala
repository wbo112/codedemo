package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object SparkSQL01_Test {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparksql")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    //导入隐式转换,这里的spark其实是环境变量对象
    //变量声明要用val
    import spark.implicits._
    val jsonDF = spark.read.json("input/user.json")
    jsonDF.createOrReplaceTempView("user")
    spark.sql("select * from user").show
    jsonDF.select("name", "age").show
    val rdd: RDD[(String, Int)] = spark.sparkContext.makeRDD(List(("zhangsan", 20), ("lisi", 30)))
    val df: DataFrame = rdd.toDF("name", "age")
    val dfToRDD: RDD[Row] = df.rdd
    val userRDD: RDD[User] = rdd.map {
      case (name, age) => {
        User(name, age)
      }
    }
    val userDS: Dataset[User] = userRDD.toDS()
    val dsToRDD: RDD[User] = userDS.rdd
    val dfToDS: Dataset[User] = df.as[User]
    val dsToDf: DataFrame = dfToDS.toDF()
    spark.stop()
  }
}

case class User(name: String, age: Int)