# coding:utf8


from pyspark.sql import SparkSession
import pandas as pd
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    df = spark.read.format("csv").schema("id INT,subject STRING,score INT").load("../data/sql/stu_score.txt")

    id_column = df['id']
    subject_column = df['subject']

    df.select(id_column, subject_column).show()

    df.select(["id", "subject"]).show()
    df.select("id", "subject").show()

    df.filter("score < 99").show()
    df.filter(df['score'] < 99).show()

    df.where("score < 99").show()
    df.where(df['score'] < 99).show()

    df.groupBy("subject").count().show()

    df.groupBy(df['subject']).count().show()

    print(type(df.groupBy('subject')))
    print(type(df.groupby('subject')))
    df.groupBy('subject').count().show()
    df.groupby('subject').count().show()
