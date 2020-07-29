package main
import (
	"fmt"
	"math/rand"
	"time"
)
func main(){
	var count int=0
	for{
		rand.Seed(time.Now().Unix())
		n:=rand.Intn(100)+1
		fmt.Println("n=",n)
		count++
		if(n==99){
			break
		}

	}
	fmt.Println("生成99 一共使用了 ",count)
label1:
	for i:=1;i<10;i++{
		for j:=1;j<10;j++{
			fmt.Println("i = ",i,",j=",j)
			if j==5 {
				break label1
			}
		}
	}
}