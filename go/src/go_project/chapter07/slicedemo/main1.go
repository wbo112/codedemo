package main
import (
	"fmt"
)

func main(){
	var arr [5]int=[...]int{1,2,3,4,5}
	slice:=arr[1:4]
	for i:=0;i<len(slice);i++{
		fmt.Printf("slice[%v]=%v\n",i,slice[i])

	}

	for k,v:=range slice {
		fmt.Println("k =",k,",v=",v)
	}

	//引用数组全部
	slice1:=arr[:]
	fmt.Println("slice1=",slice1)
	//引用数组从1开始到结束
	slice2:=arr[1:]
	fmt.Println("slice2=",slice2)
	//引用数组从0开始到3
	slice3:=arr[:3]
	fmt.Println("slice3=",slice3)
	//切片再切片
	slice4:=slice3[1:]
	fmt.Println("slice4=",slice4)

	//用append的内置函数,对切片进行动态扩容

	var  slice5 []int=[]int{100,200,300}
	//append等于新创建,不会修改原来的
	slice6:=append(slice5,400,500)

	fmt.Println("slice5=",slice5)
	fmt.Println("slice6=",slice6)

	slice7:=append(slice5,slice6...)
	fmt.Println("slice7=",slice7)

	var arrA=[]int{1,2,3,4,5}
	sliceA:=arrA[:]
	var arrB=[]int{100,200,300}
	
	sliceB:=arrB[:]
	fmt.Println("arrA=",arrA)
	fmt.Println("arrB=",arrB)
	fmt.Println("==================")
	//sliceB拷贝到sliceA,会改变底层数组
	copy(sliceA,sliceB)
	fmt.Println("arrA=",arrA)
	fmt.Println("arrB=",arrB)
}