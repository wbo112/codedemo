package main
import(
	"fmt"
)

func main(){

	//string底层是byte数组,可以切片
	str:="hello@china"
	slice:=str[6:]
	fmt.Println("slice=",slice)

	//str[0]='a'  string是不可变的
	//这里应该是重新拷贝了一份
	arr1:=[]byte(str)
	arr1[0]='a'
	str1:=string(arr1)
	fmt.Println("str=",str)
	fmt.Println("str1=",str1)

	//rune按照字符切分,可以用来处理中文
arr2:=[]rune(str)
arr2[0]='中'
str2:=string(arr2)
fmt.Println("str2=",str2)
}