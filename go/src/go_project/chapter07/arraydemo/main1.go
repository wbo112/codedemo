package main
import (
	"fmt"
)
//数组是值类型,传参会把整个数组拷贝过去
func  test01(arr [3]int){
	arr[0]=123
	fmt.Println("test01 arr=",arr)
}
func  test02(arr *[3]int){
	(*arr)[0]=123
	fmt.Println("test02 arr=",arr)
}
func main(){
	heroes :=[...]string{"a","b","c"}

	for i,v:=range heroes{
		fmt.Printf("i=%v, v=%v\n",i,v)
	}

	var  arr01 [3]float64
	var arr02 [3]string
	var arr03 [3]bool
	fmt.Println("arr01= ",arr01)
	fmt.Println("arr02=",arr02)
	fmt.Println("arr03=",arr03)
	arr:=[...]int{1,2,3}
	test01(arr)
	fmt.Println("arr=",arr)
	test02(&arr)
	fmt.Println("arr=",arr)
}