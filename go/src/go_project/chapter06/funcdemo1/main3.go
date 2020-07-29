package main
import(
	"fmt"
)

func main(){

	res1:=func(n1 int,n2 int) int{

		return n1+n2
	}(10,20)
	fmt.Println("res1=",res1)
}