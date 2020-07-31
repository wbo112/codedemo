package main
import (
	"fmt"
)


func main(){
	cities:=make(map[string]string)
cities["no1"]="北京"
cities["no2"]="上海"
cities["no3"]="广州"
fmt.Println(cities)
cities["no4"]="深圳"
fmt.Println(cities)
cities["no3"]="天津"
fmt.Println(cities)

//map的删除,如果key不存在也不会报错
delete(cities,"no5")
fmt.Println(cities)

//map没有清空函数,需要清空就需要遍历删除key或者重新make
cities=make(map[string]string)
fmt.Println(cities)

//map的查找
val,ok:=cities["no1"]
if ok{
	fmt.Println("exist key no1")
}else {
	fmt.Println("exist not key no1")
}
}