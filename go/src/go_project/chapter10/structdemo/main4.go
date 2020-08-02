package main
import(
	"fmt"
	"encoding/json"
)

type A struct{
	Num int
}
type B struct{
	Num int
}
type Monster struct{
	Name string `json:"name"`  //结构体的标签   tag
	Age int `json:"age"`
	Skill string `json:"skill"`
}
//type  C A
func main(){
	// var a A
	// var b B
	//结构体可以强转,需要字段类型完全一致
	// a=(A)b
	// fmt.Println(a,b)
	//var c C
	//c=a  不同的类型,不能强转
	//c=(C)a 
	//fmt.Pintln(c)

	monster:=Monster{"牛魔王",500,"芭蕉扇"}
	jsonStr,err:=json.Marshal(monster)
	if err!=nil{
		fmt.Println("json 处理错误",err)
	}else{
		fmt.Println("jsonStr=",string(jsonStr))
	}
}