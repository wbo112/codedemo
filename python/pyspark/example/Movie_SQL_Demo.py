# coding:utf8
import time

from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").config("spark.sql.shuffle.partition",2).getOrCreate()

    sc = spark.sparkContext

    schema = StructType().add("user_id", StringType(), nullable=True).add("movie_id", IntegerType(), nullable=True).add(
        "rank", IntegerType(), nullable=True).add("ts", StringType(), nullable=True)
    df = spark.read.format("csv").option("sep", "\t").option("header", False).option("encoding", "utf-8").schema(
        schema=schema).load("/input/data/sql/u.data")
    df.groupBy("user_id").avg("rank").withColumnRenamed("avg(rank)", "avg_rank").withColumn("avg_rank",
                                                                                            F.round("avg_rank",
                                                                                                    2)).orderBy(
        "avg_rank", ascending=False).show()

    df.createTempView("movie")

    spark.sql(
        "select movie_id,round(avg(rank),2) as avg_rank from movie group by movie_id order by avg_rank desc ").show()

    # TODO 1 大于平均分的电影
    print(df.select(F.avg(df['rank'])).first()['avg(rank)'])
    print("大于平均分 %d" % df.where(df['rank'] > df.select(F.avg(df['rank'])).first()['avg(rank)']).count())

    # TODO 2  查询高分电音中(>3)打分次数最多的用户,此人打分的平均分
    user_id = df.where("rank >3").groupBy("user_id").count().withColumnRenamed("count", "cnt").orderBy("cnt",
                                                                                                       ascending=False).limit(
        1).first()["user_id"]
    # 计算平均打分
    df.filter(df['user_id'] == user_id).select(F.round("rank", 2)).show()

    # TODO 3查询每个用户的平均分，最低打分，最高打分

    df.groupBy("user_id").agg(F.round(F.avg("rank"), 2).alias("avg_rank"), F.min("rank").alias("min_rank"),
                              F.max("rank").alias("max_rank")).show()

    # TODO 4 评分超过100次的电影的平均分，排名 TOP 100

    df.groupBy("movie_id").agg(F.count("movie_id").alias("cnt"), F.round(F.avg("rank"), 2).alias("avg_rank")).where(
        "cnt>100").orderBy("avg_rank", ascending=False).show()

    time.sleep(10000)


   # 1  agg  GroupedData对象的API，作用是可以在分组里面写多个聚合函数
   # 2  alias 它是Column对象的API，可以针对一个列进行改名
   # 3 withColumnRenamed  它是DataFrame的API,可以对DF中的列进行改名,可以链式调用
   # 4 orderBy   它是DataFrame的API,可以对DF中按照指定列进行升序、降序排序
   # 5 first  返回DataFrame中第一行的Row对象