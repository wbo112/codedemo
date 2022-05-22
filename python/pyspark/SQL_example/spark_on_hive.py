# coding:utf8

from pyspark.sql import SparkSession

if __name__ == '__main__':
    spark = SparkSession.builder.appName("test").master("local[*]").config("spark.sql.shuffle.partitions", 3).config(
        "spark.sql.warehouse.dir", "hdfs://hadoop1:9000").config("hive.metastore.uris",
                                                                 "thrift://hadoop1:9083").enableHiveSupport().getOrCreate()
    sc = spark.sparkContext

    spark.sql("select * from student").show()
