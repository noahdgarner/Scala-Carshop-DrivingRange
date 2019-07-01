package Carshop

abstract class Person(val name:String, val age: Int, var experience: Int) { //a person has a name, an age, and an experience level

  def changeXP(xpLevel: Int)
  def talk(greeting:String):String


}
