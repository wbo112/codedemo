package main
import (
	"fmt"
)

func main(){
for i:=1;i<=10;i++{
	fmt.Println("i = ",i)
}
fmt.Println("**********")
j:=1
for j<=10{
	fmt.Println("j = ",j)
	j++
}

fmt.Println("**********")
k:=1
for{
if(k>10){
	break;
}
fmt.Println("k = ",k)
k++
}

fmt.Println("**********")
n:=1
for;;{
if(n>10){
	break;
}
fmt.Println("n = ",n)
n++
}

//字符串遍历
//中文占用多个字节,这种遍历一次取一个字节,中文会乱码
var str string="hello world"
for i:=0;i<len(str);i++{
	fmt.Printf("%c ",str[i])
}
fmt.Println()

//rune按照字符遍历
var str1 string="北京"
str2:=[]rune(str1)
for index,val:=range str2{
	fmt.Printf("index=%d,val=%c\n",index,val)
}

for index,val:=range str1{
	fmt.Printf("index=%d,val=%c\n",index,val)
}

}