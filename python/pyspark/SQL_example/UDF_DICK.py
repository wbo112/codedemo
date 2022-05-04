# coding:utf8
import string

from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    rdd = sc.parallelize([[1], [2], [3]])

    df = rdd.toDF(['num'])


    def process(data):
        return {"num": data, "letters": string.ascii_letters[data]}


    ufd2 = spark.udf.register("udf1", process,
                              StructType().add("num", IntegerType(), nullable=True).add("letters", StringType(),
                                                                                        nullable=True))

    df.selectExpr("udf1(num)").show(truncate=False)
    df.select(ufd2(df["num"])).show(truncate=False)
