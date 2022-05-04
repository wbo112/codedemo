# coding:utf8
from pyspark import SparkContext, SparkConf

if __name__ == "__main__":
    conf=SparkConf().setAppName("test_rdd_create").setMaster("local[*]")
    sc=SparkContext(conf=conf)
    rdd=sc.parallelize([1,2,3,4,5,6,7,8,9,0])

    print("默认分区:",rdd.getNumPartitions())

    rdd = sc.parallelize([1, 2, 3, 4, 5, 6, 7, 8, 9, 0],3)
    print("分区:",rdd.getNumPartitions())

    print("rdd 的内容:",rdd.collect())
