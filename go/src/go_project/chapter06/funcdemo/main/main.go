package main
import (

	"fmt"
	util  "go_project/chapter06/demo/utils"//这里实际是文件夹
)

func main(){

	var n1 float64=1.1
	var n2 float64=2.0
	fmt.Printf("n1*n2 =%.2f\n",util.Calc(n1,n2,'/'))//这里是包名.函数名
	fmt.Println(util.A())
}