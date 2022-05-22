# coding:utf8


from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.storagelevel import StorageLevel

from pyspark.sql.types import StringType

if __name__ == '__main__':
    spark = SparkSession.builder.appName("example").master("local[*]").config("spark.sql.shuffle.partitions",
                                                                              "2").config(
        "spark.sql.warehouse.dir", "hdfs://hadoop1:9000/user/hive/warehouse").config("spark.debug.maxToStringFields",
                                                                                     "100").config(
        "hive.metastore.uris",
        "thrift://hadoop1:9083").enableHiveSupport().getOrCreate()
    df = spark.read.format("json").load("/input/data/mini.json").dropna(thresh=1, subset=['storeProvince']).filter(
        "storeProvince!='null'").filter("receivable<10000").select('storeProvince', 'storeID', 'receivable', 'dateTS',
                                                                   'payType')

    data = df.groupBy('storeProvince').sum('receivable').withColumnRenamed('sum(receivable)', 'money').withColumn(
        'money', F.round('money', 2)).orderBy('money', ascending=False)
    # data.show()
    #
    # data.write.mode("overwrite").format("jdbc").option("url",
    #                                                    "jdbc:mysql://hadoop1:3306/test?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC").option(
    #     "dbtable", "province_sale").option("user", "root").option("password", "123456").save()
    # data.write.mode("overwrite").saveAsTable("default.province_sale", "parquet")

    top3_df = data.limit(3).select('storeProvince').withColumnRenamed('storeProvince', 'top3storeProvince')

    top3_data = df.join(top3_df, on=df['storeProvince'] == top3_df['top3storeProvince'])

    top3_data.show()
    top3_data.persist(StorageLevel.MEMORY_AND_DISK)
    provice_hot_data = top3_data.groupBy('storeProvince', 'storeID',
                                         F.from_unixtime(df['dateTS'].substr(0, 10), "yyyy-MM-dd").alias('day')).sum(
        'receivable').withColumnRenamed('sum(receivable)', 'money').filter('money>1000').dropDuplicates(
        subset=['storeID']).groupBy('storeProvince').count()
    provice_hot_data.show()

    # provice_hot_data.write.mode("overwrite").format("jdbc").option("url",
    #                                                                "jdbc:mysql://hadoop1:3306/test?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC").option(
    #     "dbtable", "province_top3_hot").option("user", "root").option("password", "123456").save()
    # provice_hot_data.write.mode("overwrite").saveAsTable("default.province_hot", "parquet")

    avg_data = top3_data.groupBy('storeProvince').avg('receivable').withColumnRenamed('avg(receivable)',
                                                                                      'money').withColumn(
        'money', F.round('money', 2)).orderBy('money', ascending=False)
    avg_data.show()

    # avg_data.write.mode("overwrite").format("jdbc").option("url",
    #                                                        "jdbc:mysql://hadoop1:3306/test?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC").option(
    #     "dbtable", "province_avg").option("user", "root").option("password", "123456").save()
    # avg_data.write.mode("overwrite").saveAsTable("default.province_avg", "parquet")
    top3_data.createTempView('province_pay')


    def udf_func(percent):
        return str(round(percent * 100, 2)) + "%"


    my_udf = F.udf(udf_func, StringType())

    payType_data = spark.sql(
        'select storeProvince,payType,(count(paytype)/total)  as percent from ('
        'select storeProvince,payType,count(1) OVER(PARTITION BY STOREPROVINCE) AS total FROM province_pay) as sub group by storeProvince,payType,total').withColumn(
        'percent', my_udf('percent'))
    payType_data.show()

    avg_data.write.mode("overwrite").format("jdbc").option("url",
                                                           "jdbc:mysql://hadoop1:3306/test?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC").option(
        "dbtable", "province_payType").option("user", "root").option("password", "123456").save()
    avg_data.write.mode("overwrite").saveAsTable("default.province_payType", "parquet")
    top3_data.unpersist()
