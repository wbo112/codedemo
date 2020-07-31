package main
import(
	"fmt"
	"sort"
)
func modify(map1 map[int]int){
	map1[10]=10
}

func main(){
	var m map[string]string
	m=make(map[string]string)
	m["no1"]="a"
	m["no2"]="b"
	var keys []string
	for k,_:=range m{
		keys=append(keys,k)
	}
sort.Strings(keys)
fmt.Println(keys)

for _,k:=range keys{
	fmt.Printf("m[%v]=%v\n",k,m[k])
}
	fmt.Println(m)
	map1:=make(map[int]int)
	map1[1]=90
	map1[2]=2
	map1[10]=20
	modify(map1)
	fmt.Println(map1)

}