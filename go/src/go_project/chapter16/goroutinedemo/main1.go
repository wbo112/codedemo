package main
import "fmt"
import "runtime"



func main(){
	cpuNum:=runtime.NumCPU()
	fmt.Println("cpuNum=",cpuNum)

	runtime.GOMAXPROCS(cpuNum)
	fmt.Println("num=",cpuNum)
}

