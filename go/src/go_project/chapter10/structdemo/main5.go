package main
import(
	"fmt"
)

type Stu struct{
	Name string
	Age int
}
//创建对象的方式
func main(){
	var stu1=Stu{"小明",19}
	fmt.Println(stu1)

	stu2:=Stu{"小王",20}
	fmt.Println(stu2)

	var stu3=Stu{
		Name:"小李",
		Age:19,
	}
	fmt.Println(stu3)
	stu4:=Stu{
		Name:"小子",
		Age:20,
	}
	fmt.Println(stu4)

	var stu5=&Stu{"小王",29}
	fmt.Println(*stu5)

}