package main
import(
	"fmt"
)

func main(){
	cities:=make(map[string]string)
	cities["no1"]="北京"
	cities["no2"]="上海"
	cities["no3"]="广州"

	for  k,v:=range cities{
		fmt.Printf("key =%v,value=%v\n",k,v)
	}


	studentMap:=make(map[string]map[string]string)
studentMap["stu01"]=make(map[string]string,3)
studentMap["stu01"]["name"]="tom"
studentMap["stu01"]["sex"]="男"
studentMap["stu02"]=make(map[string]string,3)
studentMap["stu02"]["name"]="mary"
studentMap["stu02"]["sex"]="女"
//map的长度
fmt.Println(len(studentMap))
for k,v:=range studentMap{
	fmt.Printf("k1=%v",k)
	for k2,v2:=range v{
		fmt.Printf("\t k2=%v,v2=%v",k2,v2)
	}
	fmt.Println()
}
}