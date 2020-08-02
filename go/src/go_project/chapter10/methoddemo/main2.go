package main
import(
	"fmt"
)

type Integer int
func (i Integer)print(){
	fmt.Println("i=",i)
}
func (i *Integer) change(){
	*i=*i+1
}


type  Student struct{
	Name string
	Age int
}


//默认输出
func (stu *Student) String() string{
	str:=fmt.Sprintf("Name=%v,Age=%v",stu.Name,stu.Age)
	return str
}
func main(){
	var i Integer=10
	i.print()
	i.change()
	fmt.Println("i=",i)
	var stu *Student=new(Student)
	(*stu).Name="tom"
	(*stu).Age=10
	fmt.Println(stu)
}