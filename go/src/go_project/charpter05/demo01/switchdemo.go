package main

import(
	"fmt"
)


func main(){
var key  byte
fmt.Println("请输入")
fmt.Scanf("%c",&key)

switch key{
case 'a':
	fmt.Println("周一")
case 'b':
	fmt.Println("周二")
case 'c':
	fmt.Println("周三")
default:
	fmt.Println("周末")

}

//switch 每个分支已经默认带了break  所以每个分支不需要写break;匹配后会跳过其他分支
//switch  可以不带default分支
var  n1 int32=20
var  n2 int64=20
n2++
switch n1{
case   20://这样是可以的
//case n2:  数据类型不匹配
	fmt.Println("ok1")
default:
	fmt.Println("没有匹配到")

}

//switch后可以不带表达式

var  age int=10
switch {
case age==10:
	fmt.Println("age==10")
case age==20:
	fmt.Println("age==20")
case  age<50:
	fmt.Println("age<50")
}




// switch后可以跟赋值语句
switch  grade:=10; {
case grade==10:
	fmt.Println("grade==10")
case grade==20:
	fmt.Println("grade==20")
case  grade<50:
	fmt.Println("grade<50")
}




// switch后case语句后跟fallthrough穿透,类似屏蔽break
var score int=10
switch   {
case score==10:
	fmt.Println("score==10")
	fallthrough
case score==20:
	fmt.Println("score==20")
	fallthrough
case  score<50:
	fmt.Println("score<50")
	fallthrough
default:
	fmt.Println("default")
}
}