package main
import (
	"fmt"
)
func main(){
	var a map [string]string
	a=make(map[string]string,10)
	a["no3"]="宋江"
	a["no2"]="卢俊义"
	a["no1"]="晁盖"
	fmt.Println(a)
cities:=make(map[string]string)
cities["no1"]="北京"
cities["no2"]="上海"
cities["no3"]="广州"

fmt.Println(cities)

var heroes map[string]string=map[string]string{
"hero1":"宋江",
"hero2":"卢俊义",
}
fmt.Println(heroes)
}