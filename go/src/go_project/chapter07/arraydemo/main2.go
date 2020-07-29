package main
import (
	"fmt"
)

func main(){
	var arr [3][5]int
	arr[1][2]=1
	arr[2][1]=2
	arr[2][2]=3
	for i:=0;i<len(arr);i++{
		for j:=0;j<len(arr[i]);j++{
			fmt.Printf("%v\t",arr[i][j])
		}
		fmt.Println()
	}


	var arr1 [2][3]int=[2][3]int{{1,2,3},{4,5,6}}
	fmt.Println("arr1=",arr1)


}