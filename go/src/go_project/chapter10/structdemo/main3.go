package main
import "fmt"
type Point struct  {
	x int
	y int
}
type Rect struct{
	leftUp, rightDown Point
}
type Rect2 struct {
	leftUp, rightDown *Point
}

func main(){

	//结构体的默认内存分布是连续的
	r1:=Rect{Point{1,2},Point{3,4}}
	fmt.Printf("r1.leftUp.x的地址=%p\tr1.leftUp.y的地址=%p\n",&r1.leftUp.x,&r1.leftUp.y)
	fmt.Printf("r1.rightDown.x的地址=%p\tr1.rightDown.y的地址=%p\n",&r1.rightDown.x,&r1.rightDown.y)
	fmt.Printf("r1.leftUp=的地址%p\tr1.rightDown的地址=%p\n",&r1.leftUp,&r1.rightDown)


	//TODO
	r2:=Rect2{&Point{1,2},&Point{3,4}}
	fmt.Printf("r2.leftUp.x的地址=%p\tr2.leftUp.y的地址=%p\n",&r2.leftUp.x,&r2.leftUp.y)
	fmt.Printf("r2.rightDown.x的地址=%p\tr2.rightDown.y的地址=%p\n",&r2.rightDown.x,&r2.rightDown.y)
	 fmt.Printf("r2.leftUp=的地址%p\tr2.rightDown的地址=%p\n",&r2.leftUp,&r2.rightDown)
}