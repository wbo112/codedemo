package main
import(
	"fmt"
)
type Person struct{
	Name string
}
func (p Person)  test1(){
	p.Name="jack"
	fmt.Println("test1",p.Name)
}

func (p *Person)test2(){
	(*p).Name="jack"
	fmt.Println("test2",p.Name)
}
func test(p Person){
	fmt.Println(p.Name)
}
func main(){
	p:=Person{"tom"}
	test(p)
	p.test1()
	(&p).test1()//这种也是值拷贝
	fmt.Println(p)

	(&p).test2()
	fmt.Println(p)
}