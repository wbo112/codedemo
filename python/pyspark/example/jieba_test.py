# coding:utf8
import jieba

if __name__=="__main__":
    content="将如下内容替换进文件内,保存即可"
    result=jieba.cut(content,True)
    print(list(result))
    print(type(result))

    result2=jieba.cut(content,False)
    print(list(result2))
    print(type(result2))


    result3=jieba.cut_for_search(content)
    print(",".join(result3))


