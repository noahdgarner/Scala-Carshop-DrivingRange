package Carshop

import scala.util.Random._

class Buggy extends Car("Buggy",carCost = 100,Gas("Cheap")) with luxury {

  var gasTankSize = 80
  val licensePlate = f"${nextInt(10)}%1d${('A' to 'Z')(nextInt(26))}${('A' to 'Z')(nextInt(26))}${('A' to 'Z')(nextInt(26))}${nextInt(1000)}%1d"

  //this will do different stuff later depending on if toyota or mercedes
  override def drive(miles:Int): Boolean = {

    if (gasTankSize-miles <=0){//make sure we can actually drive this far
      println("You cannot drive that far.")
      return false
    }
    else {
      gasTankSize -= miles //current gas left, Toyota get worse gase mileage than mercedes
      println("You drove: " + miles + "." + "\nYou have: " + gasTankSize + " miles left.")
      return true
    }
  }


  override def luxury(isLuxury: Boolean): Boolean = false //a buggy is not a luxury car

  override def toString = "Buggy" //must be here or we will print bad string data
}
