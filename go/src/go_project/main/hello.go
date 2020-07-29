package main
import "fmt"
//变量定义


//定义全局变量
var qn1=100
var qn2=100

//定义全局变量
var (
qm1=1
qm2="qm2"

)
func main(){
	//fmt.Println("hello world")

	//声明单个变量
	var  i  int
	fmt.Println("i=",i)
	
	//声明变量并赋值
	var a=10
	fmt.Println(" a =",a)
	
	//赋值单个变量并声明
	b:="hello"
	fmt.Println("b=",b)
	
	//声明变量，指定类型并赋值
	var c string="c"
	fmt.Println("c=",c)
	
	//声明多个变量
	var  n1,n2,n3 int
	fmt.Println("n1 =",n1,"n2 =",n2,"n3=",n3)

	//赋值多个变量,变量也是在这里赋值
	m1,m2, m3 := "m1","m2",8
	fmt.Println("m1=",m1,"m2=",m2,"m3=",m3)
	//var   a:=10   这种方式是错误的
	fmt.Println("qn1=",qn1,"qn2=",qn2,"qm1=",qm1,"qm2=",qm2)
}