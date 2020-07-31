package main
import(
	"fmt"
)

type Person struct{
	Name string
	Age int
}
//创建结构体的几种方式
func main(){
	p1:=Person{}
	fmt.Println(p1)
	p2:=Person{"p2",20}
	fmt.Println(p2)
	var p3 *Person=new(Person)

	(*p3).Name="smith" //标准方式

	p3.Name="john"//也可以这样写 底层也是转成了(*p3).Name这种方式
	fmt.Println(*p3)



	var p4 *Person=&Person{}
	p4.Name="scott"
	(*p4).Age=20
	fmt.Println(*p4)


	var p5 *Person=p4

	fmt.Printf("p4=%v,p4的地址=%p\n",*p4,p4)
	fmt.Printf("p5=%v,p5的地址=%p\n",*p5,p5)

}