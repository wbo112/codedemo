package main
import (
	"fmt"
)

func main(){
var intArr [5]int=[...]int{1,2,3,4,5}

//声明定义一个切片
//slice:=intArr[1:3]
//1 slice是切片名
// intArr 表示slice引用到intArr这个数组
// 引用从数组下标1开始,到下标3(不包含下标3)
slice:=intArr[1:3]
fmt.Println("slice=",slice)
fmt.Println("slice元素个数=",len(slice))
fmt.Println("slice的容量=",cap(slice))//容量是动态变化的


fmt.Printf("intArr[1]的地址=%p\n",&intArr[1])
fmt.Printf("slice[0]的地址=%p\n",&slice[0])


//make方式创建切片 类型,元素个数,容量
//make创建的切片对应的数组由make维护,对外不呈现
var  slice1 []float64=make([]float64,5,10)
slice1[1]=2
slice1[3]=5

fmt.Println(slice1)
fmt.Println("slice1的size=",len(slice1))
fmt.Println("slice1的容量=",cap(slice1))

//定义一个切片
var  strSlice []string=[]string{"tom","jack","mary"}
fmt.Println("strSlice=",strSlice)
fmt.Println("strSlice的Size=",len(strSlice))
fmt.Println("strSlice的容量=",cap(strSlice))
}