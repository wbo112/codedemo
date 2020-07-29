package main
import(
	"fmt"
	"errors"
)


//自定义错误
func readConf(name string)(err error){
	if name=="config.ini"{
		return nil
	}else{
		return errors.New("读取文件错误")
	}
}


func main(){
err:=readConf("config1.ini")
if err!=nil{
	//执行到这里,整个程序就会终止
	panic(err)
}
fmt.Println("read config Ok")
}