package main
import(
	"fmt"
)
//接口
//接口的方法不能有方法体
//接口中不能有变量
type Usb interface{
	Start()
	Stop()
}
//结构体不需要显示标注指定实现接口,只要实现了接口的所有方法就可以了
type Phone struct{

}
type Camera struct{

}

//接口的继承
type  SubUsb interface{
	Usb
	Run()
}
type Usb2 interface{
	Start()//接口的方法不能有方法体
	Stop()
}
func (p Phone) Start(){
	fmt.Println("手机开始工作...")
}

func (p Phone)Stop(){
	fmt.Println("手机停止工作...")
}
func(p Phone)Run(){
	fmt.Println("手机正在工作...")
}
func (c Camera) Start(){
	fmt.Println("相机开始工作...")
}

func (c Camera)Stop(){
	fmt.Println("相机停止工作...")
}
type Computer struct{

}
type Computer2 struct{

}
//接收一个usb类型的参数
func (c Computer)  Working(usb Usb){
	usb.Start()
	usb.Stop()
}
//接收一个usb类型的参数
func (c Computer)  Work(subUsb SubUsb){
	subUsb.Start()
	subUsb.Run()
	subUsb.Stop()
}
func (c Computer2)  Working(usb2 Usb2){
	usb2.Start()
	usb2.Stop()
}
func main(){
 phone:=Phone{}
 camera:=Camera{}
 computer:=Computer{}
 computer.Work(phone)
 computer2:=Computer2{}
 computer2.Working(camera)

//接口数组可以放入实现接口的多种类型
 var usbArr [3]Usb2
 fmt.Println(usbArr)
 usbArr[0]=Phone{}
 usbArr[1]=Camera{}
 usbArr[2]=Phone{}
 fmt.Println(usbArr)
}