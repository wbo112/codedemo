package com.atguigu.chapter07.abstractdemo

object BankDemo {
  def main(args: Array[String]): Unit = {
val account=new Account("gh00001",9542.2,"123456")
    account.query("123456")
    account.withDraw("123456",100)
    account.query("123456")
  }
}

class Account(inAccountNo:String,inBalance:Double,inPwd:String){
  val  accountNo=inAccountNo
  var balance=inBalance
  var pwd=inPwd

  def query(pwd:String):Unit={
    if(!this.pwd.equals(pwd)){
      println("密码错误")
      return
    }
    printf("账号为%s 当前余额是%f\n",this.accountNo,this.balance)
  }


def  withDraw(pwd:String,money:Double):Any={
  if(!this.pwd.equals(pwd)){
    println("密码不正确")
    return
  }
  if(this.balance<money){
    println("余额不足")
    return

  }
  this.balance-=money
  return money
}
}
