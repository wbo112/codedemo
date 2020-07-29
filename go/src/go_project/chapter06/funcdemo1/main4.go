package main
import (
	"fmt"
	"strings"
)
//累加器
func AddUpper() func (int) int{
var n int=10
return func(x int)int{
	n=n+x
	return n
}

}
func   makeSuffix(suffix string)func (string) string{
	return func (name string) string{
		if !strings.HasSuffix(name,suffix){
			return name+suffix
		}
		return name
	}
}
func main(){
	f:=AddUpper()
	fmt.Println(f(1))
	fmt.Println(f(2))
	f2:=makeSuffix(".jpg")
	fmt.Println("文件名处理后=",f2("winter"))
	fmt.Println("文件名处理后=",f2("spring.jpg"))
}