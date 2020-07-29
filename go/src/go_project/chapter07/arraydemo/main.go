package main
import(
	"fmt"
)
//数组学习
func main(){

var  hens [6]float64;
hens[0]=1.0
hens[1]=2.0
hens[2]=3.0
hens[3]=4.0
hens[4]=5.0
hens[5]=6.0
totalWeight:=0.0
for i:=0;i<len(hens);i++{
	totalWeight+=hens[i]
}
fmt.Printf("totalWeight=%v,avgWeight=%v\n",totalWeight,totalWeight/float64(len(hens)))
fmt.Printf("hens的地址=%p,hens[0]的地址=%p,hens[1]的地址=%p\n",&hens,&hens[0],&hens[1])


//数组定义的其他集中方式
var numArr01 [3]int=[3]int{0,1,2}
fmt.Println("numArr01=",numArr01)

var numArr02 =[3]int{1,2,3}
fmt.Println("numArr02=",numArr02)

var numArr03=[...]int{1,2,3}
fmt.Println("numArr03=",numArr03)

var numArr04=[...]int{1:1,0:3,2:3}
fmt.Println("numArr04=",numArr04)

numArr05 :=[...]string{"a","b","c"}
fmt.Println("numArr05=",numArr05)

}