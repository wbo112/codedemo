# coding:utf8
import re

from pyspark import SparkContext, SparkConf

if __name__ == "__main__":
    conf = SparkConf().setAppName("test_rdd_create").setMaster("local[*]")

    sc = SparkContext(conf=conf)

    file_rdd = sc.textFile("../data/accumulator_broadcast_data.txt")

    abnoramla_char = [',', '.', ',', '!', '#', '$', '%']

    broadcast = sc.broadcast(abnoramla_char)

    acmlt = sc.accumulator(0)

    lines_rdd = file_rdd.filter(lambda line: line.strip())

    data_rdd = lines_rdd.map(lambda line: line.strip())
    print(data_rdd.collect())
    words_rdd = data_rdd.flatMap(lambda line: re.split(r"\s+", line))


    def filter_func(data):
        global acmlt

        abnormal_chars = broadcast.value

        if data in abnormal_chars:
            acmlt += 1
            return False
        else:
            return True


    normal_words_rdd = words_rdd.filter(filter_func)

    result_rdd = normal_words_rdd.map(lambda x: (x, 1)).reduceByKey(lambda a, b: a + b)

    print(result_rdd.collect())

    print(acmlt)
