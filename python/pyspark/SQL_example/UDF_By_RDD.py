# coding:utf8
import string

from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    rdd = sc.parallelize([1, 2, 3, 4, 5], 3)

    df = rdd.map(lambda x: [x]).toDF(['num'])

    single_partition_rdd = df.rdd.repartition(1)
    print(single_partition_rdd.collect())


    def process(iter):
        sum = 0
        for row in iter:
            sum += row['num']
        return [sum]

    #模拟聚合UDF
    print(single_partition_rdd.mapPartitions(process).collect())
