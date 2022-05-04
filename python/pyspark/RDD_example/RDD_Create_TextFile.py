# coding:utf8
import time

from pyspark import SparkContext, SparkConf

if __name__ == "__main__":
    conf = SparkConf().setAppName("test_rdd_create").setMaster("local[*]")
    sc = SparkContext(conf=conf)
    rdd = sc.textFile(r"D:\work\env.txt")
    print("默认分区:", rdd.getNumPartitions())

    rdd = sc.textFile(r"D:\work\env.txt", 3)
    print("分区:", rdd.getNumPartitions())

    print("rdd 的内容:", rdd.collect())

    file_rdd = sc.textFile("hdfs://hadoop1:9000/input/words.txt")
    file_rdd.cache()
    print("rdd 的内容:", file_rdd.collect())

    rdd1 = file_rdd.flatMap(lambda  x:x.split(" ")).map(lambda x:(x,1)).groupByKey().mapValues(lambda x: sum(x))

    print(rdd1.collect())
    time.sleep(100000)
