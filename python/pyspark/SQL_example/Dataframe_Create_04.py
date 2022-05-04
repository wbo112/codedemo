# coding:utf8


from pyspark.sql import SparkSession
import pandas as pd
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    schema = StructType().add("name", StringType(), nullable=True)
    df = spark.read.format("text").schema(schema=schema).load("../data/sql/people.txt")

    df.printSchema()
    df.show()
