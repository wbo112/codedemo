package main
import (
	"fmt"
)

func test(n1 int){
	n1=n1+1
	fmt.Println("n1=",n1)
}
//go 不支持函数重载
func  sum(n1 int,n2 int) int{
	return n1+n2
}

//可以返回多个值，用()
func getSumAndSub(n1 int,n2 int) (int,int){
	sum:=n1+n2
	sub:=n1-n2
	return sum,sub
}
func main(){
	n1:=10
	test(n1)
	fmt.Println("n1=",n1)
	s:=sum(1,2)
	fmt.Println("s=",s)

	res1,res2:=getSumAndSub(3,2)
	fmt.Println("res1=",res1,",res2=",res2)

	//不需要的值,可以用_来接收
	_,r2:=getSumAndSub(5,2)
	fmt.Println("r2=",r2)
}