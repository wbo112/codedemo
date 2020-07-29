package main
import "fmt"

func calc(n1 float64,n2 float64,operator byte) float64{
	var val float64=0.0
	switch operator{
	case '+':
		val=n1+n2
	case '-':
		val=n1-n2
	case '*':
		val=n1*n2
	case '/':
		val=n1/n2
	default:
		fmt.Println("Error")
		
	}
	return val
}

func main(){

	var n1 float64=1.1
	var n2 float64=2.0
	fmt.Println("n1*n2 =",calc(n1,n2,'*'))
}