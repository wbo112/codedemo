# coding:utf8
from pyspark import SparkContext, SparkConf

if __name__ == "__main__":
    conf = SparkConf().setAppName("test_rdd_create").setMaster("local[*]")

    sc = SparkContext(conf=conf)

    rdd = sc.parallelize([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 2)

    count = 0


    def map_func(data):
        global count
        count += 1
        # print(count)
        return count


    rdd.map(map_func).collect()
    print(count)

    acmlt = sc.accumulator(0)


    def map_func1(data):
        global acmlt
        acmlt += 1
        # print(count)
        return acmlt


    rdd.map(map_func1).collect()
    print(acmlt)
