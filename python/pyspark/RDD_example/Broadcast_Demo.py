# coding:utf8


from pyspark import SparkConf, SparkContext, StorageLevel

from operator import add

if __name__ == "__main__":
    # conf = SparkConf().setAppName("test").setMaster("local[*]")
    conf = SparkConf().setAppName("test")
    sc = SparkContext(conf=conf)
    stu_list = [(1, "a", 1)]
    rdd=sc.parallelize([(1,"c",11)])

    broadcast = sc.broadcast(stu_list)


    def map_func(data):
        id=data[0]
        name=""
        for stu_info in broadcast.value:
            stu_id=stu_info[0]
            name=stu_info[1]
            break
        return name
    print(rdd.map(map_func).collect())

