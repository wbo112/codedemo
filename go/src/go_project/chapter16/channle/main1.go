package main
import(
	"fmt"
)

var (
	myMap=make(map[int]int,10)
)

func test(n int){
	res:=1
 for i:=1;i<=n;i++{
	 res*=i
 }
 myMap[n]=res
}
func main(){
for i:=0;i<=200;i++{
	go test(i)
}
fmt.Println(mymap)
}