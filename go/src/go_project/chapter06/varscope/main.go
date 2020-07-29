package main
import(
	"fmt"
)

//全局变量
// 小写字母开头  本包可用
//大写字母开头  本包和其他包都可用
var age int=50
var Name string="jack~"

func a(){
	age:="abc"
	Name:=19
	fmt.Println("a.age=",age)
	fmt.Println("a.Name=",Name)
}

func main(){
	a()
	fmt.Println("main age=",age)
	fmt.Println("main Name=",Name)
}