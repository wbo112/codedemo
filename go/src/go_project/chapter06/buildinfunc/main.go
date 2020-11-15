package main
import(
	"fmt"
)

func main(){
	num1:=100
	fmt.Printf("num1的类型%T,num1的值=%v,num1的地址=%v\n",num1,num1,&num1)
	num2:=new(int)
	*num2=100
	fmt.Printf("num2的类型%T,num2的值=%v,num2的地址=%v,*num2的值=%v\n",num2,num2,&num2,*num2)
	a:=[]*demo1{{1}}
	fmt.Printf("a的类型%T\ta[0]的类型%T\n",a[0])
	fmt.Println(a[0].a)
}
type demo1 struct{
	a int
}