# coding:utf8


from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    rdd = sc.parallelize([1, 2, 3, 4, 5, 6, 7, 8, 9, 0]).map(lambda x: [x])

    df = rdd.toDF(["num"])


    # TODO 1

    def num_ride_10(num):
        return num * 10


    # 参数1 UFD名称
    # 参数2 UFD的处理逻辑,是一个单独的函数
    # 参数3 生命UDF的返回值类型
    ufd1 = spark.udf.register("udf1", num_ride_10, IntegerType())

    # SQL表达式执行
    df.selectExpr("udf1(num)").show()

    df.select(ufd1(df['num'])).show()

    # 无法用于SQL分格
    ufd2 = F.udf(num_ride_10, IntegerType())

    df.select(ufd2(df['num'])).show()
