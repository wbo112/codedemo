package main
import(
	"fmt"
	"flag"
)

func main(){
var user string
var pwd string
var port int
var host string
flag.StringVar(&user,"u","","用户名默认为空")
flag.StringVar(&pwd,"pwd","","密码默认为空")
flag.StringVar(&host,"h","localhost","主机名,默认为localhost")
flag.IntVar(&port,"port",3306,"默认为3306")
flag.Parse()
fmt.Printf("user =%s,pwd=%s,host=%s,port=%d\n",user,pwd,host,port)
 
}