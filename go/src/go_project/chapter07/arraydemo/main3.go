package main
import (
	"fmt"
	"math/rand"
	"time"
)

func main(){
	rand.Seed(time.Now().UnixNano())
	var intArr [5]int
	  for i:=0;i<len(intArr);i++{
		  intArr[i]=rand.Intn(100)
	  }
	  fmt.Println("intArr=",intArr)
	  temp:=0
	  for i:=0;i<len(intArr)/2;i++{
		  temp=intArr[len(intArr)-i-1]
		
		  intArr[len(intArr)-i-1]=intArr[i]
		  intArr[i]=temp
	  }
	  fmt.Println("intArr=",intArr)
}