package main
import (

	"fmt"
)
//可变参数
//可变参数必须是最后一个参数
func sum(n1 int,args... int)int{
sum:=n1
for i:=0;i<len(args);i++{
	sum+=args[i]
}
return sum
}

//参数类型相同,可以写一个
func s1(n1,n2 int)int{
	return n1+n2
}
func main(){
	s:=sum(1,2,3,4,5)
	fmt.Println("s=",s)
	res:=s1(1,2)
	fmt.Println("res=",res)
}

