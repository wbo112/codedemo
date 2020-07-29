package abc


import "fmt"
//函数首字母大写表示public 可以被别的包调用
func Calc(n1 float64,n2 float64,operator byte) float64{
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