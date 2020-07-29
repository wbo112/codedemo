package main

import (
	"fmt"
)
//  先执行全局变量,再执行init方法,最后执行main方法
//如果import了 其他文件需要先执行其他文件的全局变量和init,再执行本文件
var  age=test()

func init(){

	fmt.Println("init()...")
}

func test() int{
	fmt.Println("test()...")
	return 90
}
func main(){
	fmt.Println("main()...")
}