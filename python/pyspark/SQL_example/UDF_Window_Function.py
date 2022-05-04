# coding:utf8


from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    rdd=sc.parallelize([("张三","class_1",99)])


    schema=StructType().add("name",StringType()).add("class",StringType()).add("score",IntegerType())

    df=rdd.toDF(schema)


    df.createTempView("stu")

    spark.sql("select *, avg(score) over() as avg_score from stu").show()


    spark.sql("select *,row_number() over(order by score desc) as dense_rank,rank() over(order by score) as rank from stu" ).show()


    spark.sql("select * ,ntile(6) over(order by score desc ) from stu").show()