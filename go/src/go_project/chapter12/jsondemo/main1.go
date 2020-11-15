package main
import(
	"fmt"
	"encoding/json"
)

type Monster struct{
	Name string   `json:"na"`//序列化后的名字就是后后面``里面的内容
	Age int
	Birthday string
	Sal float64
	Skill string
}

func testStruct(){
	var monster =Monster{
Name:"牛魔王",
Age:500,
Birthday:"2011-11-11",
Sal:8000.0,
Skill:"牛磨拳",

	}
	data,err:=json.Marshal(&monster)
	if err!=nil{
		fmt.Println("序列化错误 err=%v\n",err)
	}
	fmt.Printf("monster 序列化后=%v\n",string(data))


}
func testMap(){
	var a map[string]interface{}

	a=make(map[string]interface{})
	a["name"]="红孩儿"
	a["age"]=30
	a["address"]="aa"
	data,err:=json.Marshal(&a)
	if err!=nil{
		fmt.Println("序列化错误 err=%v\n",err)
	}
	fmt.Printf("a 序列化后=%v\n",string(data))

}
func main(){
	testStruct()
	testMap()
}