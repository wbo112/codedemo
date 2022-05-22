# coding:utf8


from pyhive import hive

if __name__ == "__main__":
    conn = hive.Connection(host="hadoop1", port=10000, username="root")

    cursor = conn.cursor()

    cursor.execute("select * from student")

    result = cursor.fetchall()

    print(result)
