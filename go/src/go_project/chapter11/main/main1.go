package main
import(
	"fmt"
)
//go中的继承
type Student struct{
	Name string
	a  string
	b string
}

type Pupil struct{
	Student//go的继承通过这种嵌套结构体
	Score float64
	a string
	int  //继承基本类型
}

//Student的方法,Pupil一样可以用
func (stu *Student) GetName()string{
	return (*stu).Name
}
func (stu Student) ThisName()string{
	return stu.Name
}
func (pupil Pupil) GetA()string{
	return pupil.Student.a//通过这种方式获取父类的字段
}
func (pupil Pupil)GetB()string{
	return pupil.b//可以获取到父类的private属性字段,这种可以直接访问父类字段
}

func main(){
	pupil:=&Pupil{
		Student{"小王","student","stu_b"},
		99.999,//这里的,少不了
		"pupil",
		10,
	}
	name:=pupil.GetName()
	fmt.Println(name)
	pupil1:=Pupil{
		Student{
			Name:"小李",
			a:"student",
			b:"stu_b",},
		99.999,//这里的,少不了
		"pupil",
		20,
	}
	fmt.Println(pupil1.ThisName())
	fmt.Println(pupil1.GetA())
	fmt.Println(pupil1.GetB())
	fmt.Println(pupil1.a)
	fmt.Println(pupil1.int)//访问基本字段
}