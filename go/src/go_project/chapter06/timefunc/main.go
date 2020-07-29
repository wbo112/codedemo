package main

import(
	"fmt"
	"time"
)

func main(){
	now:=time.Now()
	fmt.Println("now=%v now type=%T",now,now)
	fmt.Println("年=",now.Year())
	fmt.Println("月=",now.Month())
	fmt.Println("日=",now.Day())
	fmt.Println("时=",now.Hour())
	fmt.Println("分=",now.Minute())
	fmt.Println("秒= ",now.Second())
	fmt.Printf("当前-年月日%d-%d-%d %d:%d:%d\n",now.Year(),now.Month(),now.Day(),now.Hour(),now.Minute(),now.Second())
	fmt.Printf(now.Format("2020-01-01 12:12:12"))

	for i:=0;i<100;i++{
		fmt.Println(i)
		time.Sleep(time.Second)
	}
}


