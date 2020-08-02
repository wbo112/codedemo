package main
import(
	"fmt"
	"os"
	"bufio"
	"io"
)
func main(){
	file,err:=os.Open("F:\\tmp\\test.txt")
	if err!=nil{
		fmt.Println("open file err=",err)
	}
	fmt.Printf("file=%v\n",file)
	defer file.Close() //函数退出时,关闭file
reader:=bufio.NewReader(file)
for{
	str,err:=reader.ReadString('\n')
	if err==io.EOF{
		fmt.Print(str)
		break
	}
	fmt.Print(str)
}
fmt.Println("读取文件结束")

}
