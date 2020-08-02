package main
import(
	"fmt"
)

type Point struct{
	x int
	y int
}
func main(){
	var a interface{}
	var point Point=Point{1,2}

	var b Point
	a=point
	b=a.(Point)//类型断言,如果类型不匹配 就会报错,报panic
	fmt.Println(b.x)

	var  f float64=1.2
	var fi interface{}
	fi=f
	y,ok:=fi.(float64)
	if ok{
		fmt.Println("类型转换成功")
	}else{
		fmt.Println("类型转换失败")
	}
	fmt.Println(y)
	if y,ok:=fi.(float32);ok {
		fmt.Println("类型转换成功")
		fmt.Println(y)
		}else{
			fmt.Println("类型转换失败")
	}
}
