# coding:utf8


import pandas as pd
from pyspark.sql import SparkSession

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    pdf=pd.DataFrame({

        "id": [1, 2, 3],
        "name": ["a", "b", "c"],
        "age":[11,12,13]
    })

    df=spark.createDataFrame(pdf)

    df.printSchema()
    df.show()
