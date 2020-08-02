package main
import(
	"fmt"
	"os"
)

func main(){
	file,err:=os.Open("F:\\tmp\\test.txt")
	if err!=nil{
		fmt.Println("open file err=",err)
	}
	fmt.Printf("file=%v",file)
	err=file.Close()
	if err!=nil{
		fmt.Println("关闭文件错误")
	}

}