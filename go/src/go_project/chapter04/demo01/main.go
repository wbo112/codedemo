package main
//没有使用到"unsafe"  前面加_
import _ "unsafe"
import (

	"fmt"
)
func test() bool{
	return true
}
func main(){
fmt.Println(10/4)
fmt.Println(-12340>>4)
fmt.Println(-12340/16)
fmt.Println(-10%3)
fmt.Println(-5%12)

var i int=10
//var a int

// ++   --只能单独使用
// a=i++

// 没有前++  只有后++
//++i
i++


//关系运算符
var  n1 int=9
var n2 int =8
fmt.Println(n1<n2)

var ii int=8


//官方推荐if 后面不用()
//if 后面有无()都可以
//if 后面一定要有{}  一行语句也要有{}
//else 不能换行输出
if ii<9 || test() {
	fmt.Println("a")
}else{
	fmt.Println("b")
}

var i1 int=15    //10进制
//go中不能直接使用2进制  
fmt.Printf("%b \n",i1)
var i2 int=015 //8进制
  
fmt.Printf("%b \n",i2)
var i3 int=0x15 //16进制
  
fmt.Printf("%b \n",i3)
}