package main
import (
	"fmt"
)

func main(){
	fmt.Println("ok1")
	goto label1
	fmt.Println("ok2")
	label1:
	fmt.Println("ok3")
}