package main
import(
	"fmt"
)

type Person  struct{
	Num int
	Name string
}


//方法 绑定到Person对象
func (p Person) test(){
	//这里传参是值拷贝
	p.Name="jack"
	fmt.Println("test()",p.Num,p.Name)
}

func (p  *Person) tests(){
	//这里传递指针,可以改变调用对象值
	(*p).Name="jack"
	fmt.Println("tests()",p.Num,p.Name)
}
//方法 绑定到Person对象
func (p Person) test1(n int){
	fmt.Println("test(n)",n)
}
func  (p Person)  getSum( a int ,b int) int{
return a+b
}
	func main(){
	var p Person
	p.Name="tom"
	p.test()
	var p1 *Person=new(Person)
	(*p1).tests()
	fmt.Println(*p1)
	p.test1(10)
	fmt.Println(p)
	sum:=p.getSum(1,2)
	fmt.Println("sum=",sum)
}