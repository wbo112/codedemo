# coding:utf8
import time

from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").config("spark.sql.shuffle.partition",
                                                                           2).getOrCreate()

    sc = spark.sparkContext

    schema = StructType().add("user_id", StringType(), nullable=True).add("movie_id", IntegerType(), nullable=True).add(
        "rank", IntegerType(), nullable=True).add("ts", StringType(), nullable=True)
    df = spark.read.format("csv").option("sep", "\t").option("header", False).option("encoding", "utf-8").schema(
        schema=schema).load("/input/data/sql/u.data")

    df.write.mode("overwrite").format("jdbc").option("url",
                                                     "jdbc:mysql://hadoop1:3306/bigdata?userSSL=false&userUnicode=true").option(
        "dbtable", "movie_data").option("user", "root").option("password", "xxx").save()

    df2 = df.read.format("jdbc").option("url",
                                        "jdbc:mysql://hadoop1:3306/bigdata?userSSL=false&userUnicode=true").option(
        "dbtable", "movie_data").option("user", "root").option("password", "xxx").load()
