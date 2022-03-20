package com.indiee.oobasics

object ooconcept extends App {

  val firstPerson = new Person("INDRAJIT", 51, "INDIA")
  println(firstPerson.name)
  firstPerson.showVals("Rajan")
  firstPerson.showVals("Dada","South Africa")

  val myAuthor = new writerNovel("INDRAJIT","BANIK", 1970)
  val myBook = new novel("It Engineering", 2010, myAuthor)
  val myNewBook = myBook.copyNew(2018)

  println(myAuthor.fullName)
  println(myBook.ageofAuthor)
  println(myNewBook.ageofAuthor)

  // instantiating a instance of counter
  val myCounter = new counter(10)
  myCounter.incc.incc.displayCounte
  myCounter.decc(10).displayCounte

  // Notation
  val myFriend = new Person("Rajan", 45, "INDIA")
  val myAnotherPerson = new Person("Deb", 55, "INDIA")
  println(firstPerson.hangsout(myFriend))
  println(firstPerson hangsout myFriend )
  println(firstPerson.+(myFriend))
  println(firstPerson.unary_!(myAnotherPerson))
  val myFriendTitle = myFriend + "Good Old Friend"
  println(myFriendTitle.name)
  val futureFriend = +myFriend
  println(s"${myFriend.age} is in next year as ${futureFriend.age}")

  println(myFriend learnsScala())
  println(firstPerson learnsScala())
  println(myFriend(30))
}

// Constructor
// Class parameter are not members
// converting a param to member use VAL
class Person(val name:String, val age:Int, country:String) {
  val address = "Centurion"

  println("Inside the Class Evaluation")

  def showVals(name: String): Unit = println(s"$name says, ${this.name} lives in $country and is $age years old")
  def showVals(name: String, country: String): Unit = println(s"$name says, ${this.name} lives in $country and is $age years old")
  def hangsout(writerF: Person):String = s"${this.name} is a good friend of ${writerF.name}"
  def +(writerF: Person):String = s"${this.name} is a good friend of ${writerF.name}"
  def +(title: String):Person = new Person(s"${this.name} ,${title}",this.age,this.country)

  def unary_! (person: Person) : String = s"${this.name} does not like the person ${person.name}"
  def unary_+ () : Person = new Person(s"${this.name}", this.age+1, this.country)

  def learns(inStr: String): String = s"${this.name} learns ${inStr}"
  def learnsScala(): String = this.learns("Scala")

  def apply(times: Int): String = s"${this.name} has been living in the country ${this.country} for ${times} years"

}

class writerNovel(firstName: String, lastName: String, val yeb: Int) {

  def fullName: String = firstName+" "+lastName
}

class novel(novelName: String, yearRelease: Int, writer: writerNovel) {

  def ageofAuthor: Int = yearRelease - writer.yeb
  def isWritteBy: String = writer.fullName
  def copyNew(newYear: Int): novel = new novel(novelName,newYear,writer)

}

class counter( val inCounter: Int = 0) {

  def incc = new counter(inCounter+1) // returning a new counter and not overwriting the existing one , IMMUTABILITY
  def decc = {
    println("In decrementing")
    new counter(inCounter-1)
  }
  // overloading
  def  incc(byNumber: Int) = new counter(inCounter+byNumber)
  // using the secondary decrement method in conjunction with recursion
  def  decc(byNumber: Int): counter = {
    if(byNumber <=0 ) this
    else decc.decc(byNumber-1)
  }
  def displayCounte = println(inCounter)
}