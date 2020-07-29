package main
import (
	"fmt"
	"strconv"

	//包名前加前缀_ 表示不使用
)
//string转基本类型
func main(){
var str string="true"
var b bool

b,_=strconv.ParseBool(str)
fmt.Printf("b type %T b=%v\n",b,b)

var str2 string="123456789"
var n1 int64
n1,_=strconv.ParseInt(str2,10,64)
fmt.Printf("n1 type %T n1 =%v\n",n1,n1)

var str3 string ="123.456"
var f1 float64
f1,_=strconv.ParseFloat(str3,64)

fmt.Printf("f1 type %T f1 =%v\n",f1,f1)

//无法转换
var str4 string ="hello"
var n3 int64
n3,_=strconv.ParseInt(str4,10,64)

fmt.Printf("n3 type %T n3 =%v\n",n3,n3)
}