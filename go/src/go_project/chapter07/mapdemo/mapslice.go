package main
import(
	"fmt"
)

func main(){
	var monsters []map[string]string
	monsters=make([]map[string]string,2)
	if monsters[0]==nil{
		monsters[0]=make(map[string]string,2)
		monsters[0]["name"]="牛魔王"
	}
	if monsters[1]==nil{
		monsters[1]=make(map[string]string,2)
		monsters[1]["name"]="铁扇公主"
	}
	fmt.Println(monsters)
	newMonster:=map[string]string{
		"name":"红孩儿",
	}
monsters=append(monsters,newMonster)
fmt.Println(monsters)
}