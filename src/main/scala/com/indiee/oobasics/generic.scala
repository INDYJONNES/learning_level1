package com.indiee.oobasics

object generic extends App {

  class genericOne[+A] {
    def addElement[B >: A](element: B): genericOne[B] = ???
    /*
    A = Cat
    When added a dog to the same list
    dog is also an Animal
    so B = Animal
    B is a super type of A
    This will return a list of super type = B
     */
  }
  object genericOne {
    def emptyList[A] : genericOne[Int] = new genericOne[Int]
  }

  class genericMul[KEY, VALUE] {

  }

  // Instantiation of the Class
  val myGenericInts = new genericOne[Int]
  val myGenericIntegers = genericOne.emptyList[Int] // using the companion object
  val myGenericStrings = new genericOne[String]

  //variance
  // class hierarchy
  class Animal
  class cat extends Animal
  class dog extends Animal

  // Covariance
  val myAnimal: Animal = new Animal
  val myAnimalCat: Animal = new cat
  class CovarianceList[+A]
  val animalList: CovarianceList[Animal] = new CovarianceList[cat]

  // no - INVARIANCE
  class Invariance[A]
  val myInvarianceList: Invariance[Animal] = new Invariance[Animal] // Maintain same type
  val myInvarianceListCats: Invariance[cat] = new Invariance[cat] // Maintain same type

  //Contravariant List
  class Contravariant[-A]
  val myContravariantCats: Contravariant[cat] = new Contravariant[Animal] //opposite relation


  // bounded types
  class cage[A <: Animal](inParam: Animal)
  val newCageDog = new cage[dog](new dog)
}
