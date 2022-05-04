# coding:utf8


from pyspark.sql import SparkSession

if __name__ == "__main__":
    spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    sc = spark.sparkContext

    rdd = sc.textFile("../data/sql/people.txt").map(lambda x: x.split(",")).map(lambda x: (x[0], int(x[1])))

    df = spark.createDataFrame(rdd, schema=['name', 'age'])

    df.printSchema()

    #显示条数，默认20条
    #是否对列信息进行截断，默认是True
    df.show(20,False)


    df.createOrReplaceTempView("people")


    spark.sql("select * from people where age<30").show()
