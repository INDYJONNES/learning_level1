package com.indiee.oobasics

import com.indiee.oobasics.obj_inheritance.Person
import com.indiee.oobasics.obj_inheritance.Person.getType

object obj_inheritance extends App {

  object Person {  // Person is a SINGLETON object ( type  + instance )
    val species = "Human"

    def getType: String = s"${Person.species}"

    // Factory method
    def apply(firstPerson: Person, secondPerson: Person): Person = new Person(firstPerson.firstname,secondPerson.lastname)
  }

  class Person(val firstname: String, val lastname: String) {
    def fullname: String = s"${firstname} ${lastname} and its is a "+getType

  }

  val indiee = new Person("INDRAJIT","BANIK")
  val pala = new Person("Anamika","Roy")
  val rajan = Person
  println(indiee.fullname)
  println(Person(pala,indiee).fullname)


    // inheritance
  class humans(val genderType: String, val bloodType: String, val fitness: String) {
    def bloodRare: String = if(bloodType == "O-") s"Special Group" else s"normal Type"
    def showFitnessAndBlood: String = s"${fitness} and ${bloodType}"
    def this(genderType: String, bloodType: String) = this(genderType,bloodType,"normal")
    def this(genderType: String) = this(genderType,"A+","normal")
  }
  class male( avgBuildType: String, avgLifeSpan: String, val continentBorn: String) extends humans("Male", "O-positive", "normal") {

    // def personBloodType: String = bloodRare
    override def bloodRare: String = if(continentBorn == "Africa" && avgLifeSpan == "50 plus") s"rare" else super.bloodRare

  }
  class female(avgBuildType: String, avgLifeSpan: String, val continentBorn: String , override val fitness: String, override val bloodType: String) extends humans("female","O-"){

    def this(continentBorn: String,fitness: String, bloodType: String ) = this("slim","40",continentBorn,fitness,bloodType)
    def this(avgBuildType: String, continentBorn: String, fitness: String, bloodType: String) = this(avgBuildType,"40",continentBorn,fitness,bloodType)

  }

  val firstMale = new male("over Average","50 plus","Africa")
  val firstFemale = new female(continentBorn = "Europe", fitness = "standard", bloodType = "rare")
  val secondFemale = new female(avgBuildType = "big", continentBorn = "Africa", fitness = "over standard", "semi-rare" )
  println(firstMale.bloodRare)
  println(firstMale.genderType) // this member is available as it is declared as val
  println(firstFemale.showFitnessAndBlood)
  println(secondFemale.showFitnessAndBlood)
  println(firstMale.showFitnessAndBlood)
}
