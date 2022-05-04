# coding:utf8


from pyspark.sql import SparkSession

from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    rdd = sc.textFile("../data/sql/people.txt").map(lambda x: x.split(",")).map(lambda x: (x[0], int(x[1])))

    df = rdd.toDF(["name", "age"])
    df.printSchema()
    df.show()

    schema = StructType().add("name", StringType(), nullable=True).add("age", IntegerType(), nullable=False)

    df2=rdd.toDF(schema=schema)

    df2.printSchema()


