package com.indiee.oobasics

object abstractExample extends App {

  abstract class gLists {

    val intLists: List[Int]

    def inTail: List[Int] = intLists.tail
    def inHead: Int = intLists.head
    // def +(inI: Int): List[Int] = intLists + inI
    def +(intLI: List[Int]): List[Int]  = this.intLists ++ intLI
    def isEmpty(): Boolean = intLists.isEmpty

    override def toString: String = if(!this.isEmpty()) intLists.toString else ""
  }

  class myFirstListInts(initLists: List[Int]) extends gLists  {
    override val intLists: List[Int] = initLists
    def unary_+ (addedList: List[Int]): myFirstListInts = new myFirstListInts(this.intLists++addedList)
    def unary_+ (classList: myFirstListInts): myFirstListInts = new myFirstListInts((this.intLists++classList.intLists))

    override def toString: String = if(!this.isEmpty()) s"${this.inHead}~"+new myFirstListInts(this.inTail).toString else "!"
  }

  val firstNumbers = new myFirstListInts(List(1,2,3))
  val myLists = List(1,5,10,15,20)
  val temp = firstNumbers.+( myLists )
  println(temp)
  val temp2 = firstNumbers.unary_+(myLists)
  println(temp2.inTail)
  println(temp2.inTail)
  val temp3 = firstNumbers.unary_+(temp2)
  println(temp2.toString)
  println(temp3.toString)
  val currentHead = firstNumbers.inHead.toString
  val currentTail = firstNumbers.inTail.toString
  // println(currentTail)
  // println(firstNumbers.toString)
}
