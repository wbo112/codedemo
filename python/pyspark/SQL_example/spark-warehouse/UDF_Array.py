# coding:utf8


from pyspark.sql import SparkSession
from pyspark.sql.types import StringType, ArrayType
from pyspark.sql import functions as F

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    rdd = sc.parallelize([["hadop spark flink"], ["hadoop flink java"]])

    df = rdd.toDF(['line'])


    def split_line(data):
        return data.split(" ")


    udf1 = spark.udf.register("udf1", split_line, ArrayType(StringType()))

    df.select(udf1(df['line'])).show()

    df.createTempView("lines")

    spark.sql("select udf1(line) from lines").show(truncate=False)

    udf2 = F.udf(split_line, ArrayType(StringType()))

    df.select(udf2(df['line'])).show(truncate=False)
