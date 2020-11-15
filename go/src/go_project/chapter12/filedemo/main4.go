package main
import(
	"fmt"
	"os"
	"bufio"
)

func main(){
 filePath:="F:\\tmp\\test1.txt"
 file,err:=os.OpenFile(filePath,os.O_WRONLY|os.O_CREATE,0666)
if err!=nil{
	fmt.Printf("open file err=%v\n",err)
	return
}
defer file.Close()
str:="hello,Gardon\r\n"
writer:=bufio.NewWriter(file)
for i:=0;i<5;i++{
	writer.WriteString(str)
}
writer.Flush()

}