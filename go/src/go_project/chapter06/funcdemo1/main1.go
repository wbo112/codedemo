package main
import (
	"fmt"
)
func getSum1(n1 int,n2 int) int{
 return n1+n2
}

//TODO
type  myFuncType  func(int,int) int
//不支持函数重载
// func getSum1(n1 int) int{
// 	return n1
//    }
func   myFun(funvar func(int,int) int,num1 int,num2 int) int{
return funvar(num1,num2)

}

func   myFun1(funvar myFuncType,num1 int,num2 int) int{
	return funvar(num1,num2)
	
	}

//特殊用法
	func  getSumAndSub(n1 int,n2 int)(sum int,sub int){
		sum=n1+n2
		sub=n1-n2
		return 
	}
func main(){
a:=getSum1
fmt.Printf("a的类型%T，getSum的类型是%T\n",a,getSum1)
res:=a(10,10)
fmt.Println("res=",res)

res2:=myFun(a,10,20)
fmt.Println("res2=",res2)

//别名类型
type myInt int
var num1 myInt
var num2 int
num1=40
//不同类型,需要显示转换
num2=int(num1)
fmt.Println("num2=",num2)


res3:=myFun1(a,10,2)
fmt.Println("res3=",res3)

a1,b1:=getSumAndSub(10,2)
fmt.Println("a1=",a1,",b1=",b1)
}