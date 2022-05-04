# coding:utf8


from pyspark.sql import SparkSession
import pandas as pd
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext


    df = spark.read.format("json").load("../data/sql/people.json")

    df.printSchema()
    df.show()
