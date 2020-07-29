package main
import(
	"fmt"
	"strconv"
)

func main(){

	//字符串长度
	str:="hello"
	fmt.Println("str len=",len(str))
	str1:="hello中国"
	fmt.Println("str1 len=",len(str1))


	//字符串遍历,处理中文问题
	r:=[]rune(str1)
	for i:=0;i<len(r);i++{
		fmt.Printf("%c\n",r[i])
	}

	//字符串转整数
	n,err:=strconv.Atoi("hello")
	if err!=nil{
		fmt.Println("转换错误",err)
	}else{
		fmt.Println("转换结果正确",n)
	}

	str1=strconv.Itoa(12345)
	fmt.Printf("str=%v,str=%T\n",str1,str1)

	var bytes=[]byte("hello go")
	fmt.Printf("bytes=%v\n",bytes)


	str2:=string([]byte{97,98,99})
	fmt.Printf("str2=%v\n",str2)


}