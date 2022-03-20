package com.indiee.learning

import scala.annotation.tailrec

object learning1 extends App {

  val x = 3 + 5
  val xIsEven = x % 2 == 0
  val xIsOdd = !xIsEven

  val xExprValue = if(x%2== 0) true else false // scala expression

  println(xIsEven)
  println(xIsOdd)
  println(xExprValue)

  // scala code block
  val xCodeBlock = {
    if (x%2==0) 1 else 0
  }

  val isEven = xCodeBlock
  println(isEven)

  println(if(!(1==3)) 0 else 1)

  println(1==2)

  // code block - right side code block is an expression which return the last statement
  val acodeBlock = {
    val inval1 = 10
    val inval2 = inval1.+(10)
    // print(if (inval2 < 100) "small valye" else "large values")   // return a UNIT
    if (inval2 < 100) "small value" else "large value"   // returns a string
  }
  println(acodeBlock)

  def repeaterFunc(inString: String, nLoops: Int): String = {
    if (nLoops <= 1) inString
    else inString+repeaterFunc(inString,nLoops-50)
  }
  println(repeaterFunc("Hey",176))

  def repeaterFuncTail(inString: String, iTimes: Int): String = {
    @tailrec
    def innerRecurr(inStringACC: String, n: Int): String ={
      if( n <= 1) inStringACC
      else innerRecurr(inStringACC+" "+inString, n-1)
    }
    innerRecurr(inString,iTimes)
  }

  println(repeaterFuncTail("Indy",20000))

  // pass by value
  def showHumantime(incomingTime: => Long): Unit = {
    println(incomingTime)
    println(incomingTime)
  }

  showHumantime(System.nanoTime())
  showHumantime(123456789123456789L)
}
