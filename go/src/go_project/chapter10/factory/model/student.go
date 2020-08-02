package model
//import "fmt"


type student struct{
	Name string
	score float64
}
func (s *student)GetScore()float64{
	return (*s).score
}
func NewStudent(n string,s float64) *student{
 return &student{
	 Name:n,
	 score:s,
 }
}