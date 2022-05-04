# coding:utf8


from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.sql.types import StringType, IntegerType, StructType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").config("spark.sql.shuffle.partition",
                                                                           2).getOrCreate()

    sc = spark.sparkContext

    df = spark.read.format("csv").option("sep", ";").option("header", True).option("encoding", "utf-8").load(
        "/input/data/sql/people.csv")

    # 数据去重
    df.dropDuplicates().show()

    # 按照指定列去重
    df.dropDuplicates(['age', 'job']).show()

    # 列中有空就删除这一行
    df.dropna().show()

    # 行中至少满足3个有效列
    df.dropna(thresh=3).show()

    # 行中指定列至少满足2个有效列
    df.dropna(thresh=2, subset=['name', 'age']).show()

    df.fillna("loss").show()

    df.fillna("N/A", subset=['job']).show()

    df.fillna({"name": "未知姓名", "age": 1}).show()
