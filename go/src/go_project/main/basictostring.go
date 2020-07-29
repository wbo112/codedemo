package main
import (
	"fmt"
	_ "unsafe"
	"strconv"
)

//数据类型转换到string
// fmt.Sprintf
//strconv
func main(){
var num1 int=99
var num2 float64=23.456
var b bool =true
var myChar byte='h'
var str string

str=fmt.Sprintf("%d",num1)
fmt.Printf("str type %T str=%v\n",str,str)


str=fmt.Sprintf("%f",num2)
fmt.Printf("str type %T str=%v\n",str,str)


str=fmt.Sprintf("%t",b)
fmt.Printf("str type %T str=%v\n",str,str)



str=fmt.Sprintf("%c",myChar)
fmt.Printf("str type %T str=%v\n",str,str)

var  num3 int=100
var num4 float64=23.1
var b2 bool=false
str=strconv.FormatInt(int64(num3),10)
fmt.Printf("str type %T str=%v\n",str,str)

str=strconv.FormatFloat(num4,'f',10,64)
fmt.Printf("str type %T str=%v\n",str,str)


str=strconv.FormatBool(b2)
fmt.Printf("str type %T str=%v\n",str,str)

var num5 int=12345
str=strconv.Itoa(num5)
fmt.Printf("str type %T str=%v\n",str,str)

}