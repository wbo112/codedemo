# coding:utf8


from pyspark.sql import SparkSession

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    df = spark.read.format("csv").schema("id INT,subject STRING,score INT").load("../data/sql/stu_score.txt")

    df.createOrReplaceTempView("score")
    df.createTempView("score_1")
    df.createGlobalTempView("score_2")  # 需要在表名前加global_temp.

    spark.sql("select count(*) from score").show()
    spark.sql("select count(*) from score_1").show()
    spark.sql("select count(*) from global_temp.score_2").show()
