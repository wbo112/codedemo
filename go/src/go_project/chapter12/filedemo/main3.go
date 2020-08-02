package main
import(
	"fmt"
	"io/ioutil"
)


func main(){
	file:="F:\\tmp\\test.txt"
	content,err:=ioutil.ReadFile(file)
	if err!=nil{
		fmt.Println("读取文件错误")
	}
	fmt.Println(string(content))

}