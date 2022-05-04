# coding:utf8


from pyspark.sql import SparkSession
from pyspark.sql import functions as F

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    rdd = sc.textFile("../data/words.txt").flatMap(lambda x: x.split(" ")).map(lambda x: [x])
    df = rdd.toDF(['word'])

    df.createOrReplaceTempView("words")

    spark.sql("select word,count(*) as cnt from words group by word order by cnt desc ").show()

    df = spark.read.format("text").load("../data/words.txt")

    df.withColumn("value", F.explode(F.split(df['value'], " "))).show()

    df.withColumn("value", F.explode(F.split(df['value'], " "))).groupBy("value").count().show()

    df.withColumn("value", F.explode(F.split(df['value'], " "))).groupBy("value").count().withColumnRenamed(
        "value",
        "word").withColumnRenamed(
        "count", "cnt").orderBy("cnt", ascending=False).show()
