package main
import (
	"fmt"
	"go_project/chapter10/factory/model"
)

func main(){
	var stu=model.NewStudent("小王",99.999)
	fmt.Println(stu.Name)
	fmt.Println((*stu).Name)
	fmt.Println(stu.GetScore())
}