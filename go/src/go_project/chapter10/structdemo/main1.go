package main
import(
	"fmt"
)
type Cat struct{
	Name string
	Age int
	Color string
	a [3]int
	b []int
}
func main(){
	// var cat1Name string="小白"
	// var cat1Age int=3
	// var cat1Color  string="白色"
	// var cat2Name string="小花"
	// var cat2Age int=3
	// var cat2Color  string="花色"
	var  cat1 Cat
	cat1.Name="小白"
	cat1.Age=10
	cat1.Color="白色"
	cat1.a[0]=1
	cat1.b=make([]int,3)
	fmt.Println(cat1)
	fmt.Println(cat1.Name)
	fmt.Printf("cat1的地址=%p\n",&cat1)
	
	//值拷贝
	cat2:=cat1
	cat2.Name="小花"
	fmt.Println("cat2.Name=",cat2.Name)
	fmt.Println("cat2.a=",cat2.a)
	fmt.Printf("cat2的地址=%p\n",&cat2)
}
	