# coding:utf8
from pyspark import SparkConf, SparkContext
import os
#os.environ["PYSPARK_PYTHON"]=r"C:\Users\wbo11\anaconda3\envs\pyspark\python.exe"
if __name__ == '__main__':
   # conf = SparkConf().setMaster("local[*]").setAppName("HelloWorld")
    conf = SparkConf().setAppName("HelloWorld")

    sc = SparkContext(conf=conf)

    file_rdd = sc.textFile("/input/words.txt")
    #file_rdd = sc.textFile(r"C:\Users\wbo11\PycharmProjects\pyspark\main.py")

    words_rdd = file_rdd.flatMap(lambda line: line.split(" "))
    print(words_rdd.collect())
    words_with_one_rdd = words_rdd.map(lambda x: (x, 1))

    result_rdd = words_with_one_rdd.reduceByKey(lambda a, b: a + b)

    print(result_rdd.collect())
