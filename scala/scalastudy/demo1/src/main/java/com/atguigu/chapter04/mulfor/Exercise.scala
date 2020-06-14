package com.atguigu.chapter04.mulfor

import scala.io.StdIn

object Exercise {
  def main(args: Array[String]): Unit = {
    val classNum = 3
    val stuNum = 5
    var score = 0.0
    var classScore = 0.0
    var totalScore = 0.0
    for (i <- 1 to classNum) {
      classScore = 0.0
      for (j <- 1 to stuNum) {
        printf("请输入第%d班级的第%d个学生的成绩\n", i, j)
        score = StdIn.readDouble()
        classScore += score
      }
      printf("第%d班级的平均分%.2f\n", classNum,classScore / stuNum)
    }
    printf("所有班级的平均分%.2f\n",score / classNum)
  }
}
