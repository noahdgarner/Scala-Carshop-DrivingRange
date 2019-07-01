package Carshop


abstract class Car(val carName:String, val carCost:Int, val gas: Gas) {

  val licensePlate: String
  //implement differntly for each car created as a subclass
  def drive(miles:Int): Boolean

}
