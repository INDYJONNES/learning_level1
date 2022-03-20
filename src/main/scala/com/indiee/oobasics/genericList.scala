package com.indiee.oobasics

object genericList extends App {

  abstract class genericList[+A] {

    def head: A
    def tail: genericList[A]

    def isEmpty: Boolean
    def add[B >: A](element: B): genericList[B]
    def printElements: String

    override def toString: String = "("+ printElements + ")"

  }

  object Empty extends genericList[Nothing] {

    def head: Nothing = throw new NoSuchElementException
    def tail: genericList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing ](element: B): genericList[B] = new Cons[B](element, Empty)

    override def printElements: String = ""
  }

  class Cons[+A](h: A, t: genericList[A]) extends genericList[A] {

    def head: A = h
    override def tail: genericList[A] = t
    override def isEmpty: Boolean = false

    override def add[B >: A](element: B): genericList[B] = new Cons[B](element, this)

    override def printElements: String = if (t.isEmpty) ""+h else h+" "+t.printElements

  }

  val listOfIntegers: genericList[Int] = Empty
  val listOfStrings: genericList[String] = Empty

  val listOfIntegers2: genericList[Int] = new Cons[Int](1,(new Cons[Int](2, new Cons[Int](3, Empty))))
  val listOfStrings2: genericList[String] = new Cons[String]("Hello", new Cons[String]("Scala", Empty))

  println(listOfIntegers2.printElements)

}
