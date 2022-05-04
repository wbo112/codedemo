# coding:utf8


from pyspark import SparkConf, SparkContext, StorageLevel

from defs import content_jieba, filter_words, append_words, extract_user_and_word
from operator import add
if __name__ == "__main__":
    #conf = SparkConf().setAppName("test").setMaster("local[*]")
    conf = SparkConf().setAppName("test")
    sc = SparkContext(conf=conf)

    #file_rdd = sc.textFile("../data/SogouQ.txt")
    file_rdd = sc.textFile("hdfs://hadoop1:9000/input/SogouQ.txt")

    split_rdd = file_rdd.map(lambda x: x.split("\t"))

    split_rdd.persist(StorageLevel.DISK_ONLY)

    # print(split_rdd.takeSample(True, 3))

    content_rdd = split_rdd.map(lambda x: x[2])

    # print(content_rdd.flatMap(content_jieba).collect())
    words_rdd = content_rdd.flatMap(content_jieba)

    filter_rdd = words_rdd.filter(filter_words)

    final_words_rdd = filter_rdd.map(append_words)

    result = final_words_rdd.reduceByKey(lambda a, b: a + b).sortBy(lambda x: x[1], ascending=False,
                                                                    numPartitions=1).take(5)

    print(result)

    user_content_rdd = split_rdd.map(lambda x: (x[1], x[2]))

    user_word_with_one_rdd = user_content_rdd.flatMap(extract_user_and_word)

    result2 = user_word_with_one_rdd.reduceByKey(lambda a, b: a + b).sortBy(lambda x: x[1], ascending=False,
                                                                            numPartitions=1).take(5)
    print(result2)

    time_rdd = split_rdd.map(lambda x: x[0])

    hour_with_one_rdd = time_rdd.map(lambda x: (x.split(":")[0], 1))

    result3=hour_with_one_rdd.reduceByKey(add).sortBy(lambda x:x[1],ascending=False,numPartitions=1).collect()

    print(result3)
