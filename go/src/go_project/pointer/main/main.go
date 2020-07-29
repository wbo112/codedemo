package main
import (
	"fmt"
	//引入其他地方的包
	//默认会加前缀 变量GOPATH + src/
	"go_project/pointer/model"
)
//基本操作
func main(){
 var i int =10
 fmt.Println("i的地址= ",&i)

var ptr *int=&i
fmt.Printf("ptr=%v,&ptr=%v\n",ptr,&ptr)
fmt.Printf("ptr指向的值=%v\n",*ptr)
//小写字母开头的变量 private,不能在其他文件中引用
fmt.Println("utila =",model.utila)

fmt.Println("utilb =",model.Utilb)
}
