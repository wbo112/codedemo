package main

import(
	"fmt"
	"unsafe"
)
// 变量或者包  有定义没有但是没有使用到   程序会报错   ,
//对于没有使用的包 可以在包前加 _
func main(){

	//查看数据类型
	var n1=100
	fmt.Printf("n1 的类型 %T，占用的字节数 = %d\n",n1,unsafe.Sizeof(n1))

	//查看字节大小
	var n2 int64=10
	fmt.Printf("n2 的类型  %T，占用的字节数 = %d\n",n2,unsafe.Sizeof(n2))

	num1:=1.1
	fmt.Printf("num1的类型 %T\n",num1)

	num2:=.123

	//科学计数法
	num3:=5.12e3
	fmt.Println("num1 =",num1,"num2=",num2,"num3=",num3)


	var c1 byte='a'
	var c2 byte='0'

	//输出字符对应的ASCII码值
	fmt.Println("c1=",c1,"c2=",c2)
	//输出字符
	fmt.Printf("c1=%c,c2=%c\n",c1,c2)

	// 中文字符可以用int输出
	var c3 int='北'
	fmt.Printf("c3=%c,c3=%d\n",c3,c3)
	  
	var c4 int=21271
	fmt.Printf("c4=%c\n",c4)

	//字符串不可变
	var address string="hello world"
	fmt.Println(address)

	//``包含的内容原样输出
	var  str string=`a\b\t\n`
	fmt.Println(str)

	//字符串拼接
	var  str1 string="hello "+ "world "
	str1+="china"
	fmt.Println(str1)

	var  a int
	var b float32
	var c bool
	var d string
	//%v ?
	fmt.Printf(" a =%v,b=%v,c=%v,d=%v\n",a,b,c,d)

	//类型转换
	var i int32=100
	var   fi float32=float32(i)
	var ii int8=int8(i)

	var i64 int64=int64(i)
	fmt.Printf("i=%v,fi=%v,ii=%v,i64=%v\n",i,fi,ii,i64)


	var  q1 int64=999999
	var q2  int8=int8(q1) //转换有溢出,不会报错
	fmt.Printf("q1=%v,q2=%v\n",q1,q2)
}