package Carshop
import scala.util.Random._

class Mercedes extends Car("Mercedes",500, Gas("Expensive")) with luxury{

  var gasTankSize = 200 //
  val licensePlate = f"${nextInt(10)}%1d${('A' to 'Z')(nextInt(26))}${('A' to 'Z')(nextInt(26))}${('A' to 'Z')(nextInt(26))}${nextInt(1000)}%4d"
  override def drive(miles:Int): Boolean = {
    if (gasTankSize <= 0){
      println("You cannot drive that far.")
     return false
    }
    else {
      gasTankSize -= miles/2 //current gas left, mercedes get better gas mileage
      println("You drove: " + miles + "." + "\nYou have: " + gasTankSize + " miles left.")
      return true
    }
  }


  override def luxury(isLegal: Boolean): Boolean = true //a mercedes is a luxury car



  override def toString = "Mercedes"
}
