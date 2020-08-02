package main
import (
	"fmt"
	"go_project/chapter11/model"
)
func main(){
	p:=model.NewPerson("小明")
	p.SetAge(60)
	fmt.Println(p)
}