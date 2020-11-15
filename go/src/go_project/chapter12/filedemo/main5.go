package main
import(
	"fmt"
	"bufio"
	"os"
	"io/ioutil"
)

func main(){
	file1Path:="F:\\tmp\\abc.txt"
	file2Path:="F:\\tmp\\abc1.txt"
	data,err:=ioutil.ReadFile(file1Path)
if err!=nil{
	fmt.Printf("read file err=%v",err)
	return
}
err=ioutil.WriteFile(file2Path,data,0666)
if err!=nil{
	fmt.Printf("write file err=%v\n",err)
	return
}

}