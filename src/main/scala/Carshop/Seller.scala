package Carshop
import Mainpack.validinputs._
import scala.collection.mutable.ListBuffer

class Seller(sellerName:String,val sellerAge:Int,var sellerXP:Int,sellerID:String) extends Person(sellerName,sellerAge,sellerXP) {
  println("Seller created.") //tells us we successfully created a seller

  //makes a new list of cars, the fact that everything is immutable really sucks
  def makeCars(numCars:Int, car: Car): List[Car] = {
    var cars = new ListBuffer[Car]()
  //note for this function to work, we had to include mutable lists at the top
    //we then had to remove the List() check in the for loop List(0 until numCars) because it was not a list
    //we then return a cars.toList which is converted to an immutable list. All because we want the seller to decide how many cars they potentially want to sell.
    if(car.carName == "Mercedes") {
      for(i <- 0 until numCars) cars+= new Mercedes
      cars.toList
    }
    else if (car.carName == "Toyota"){
      for (i <- 0 until numCars) cars+= new Toyota
      cars.toList
    }
    else
      for (i <- 0 until numCars) cars+= new Buggy
      cars.toList
  }

  //change this fucking function if you add more types of cars
  def checkInventory(carName:String, inventory:List[List[Car]], buyer:Buyer):List[List[Car]] = {
      for (i <- 0 to inventory.length-1) {
        if (inventory(i).head.carName == carName){
          println("You're in luck, we have a  " + carName)
          if (buyer != Nil) { //so if we checkInventory for a seller to use a car, he can
            giveCar(inventory(i).head, buyer) //give the car to buyer, and
          }
          var newSubList = remove(inventory(i).head,inventory(i)) //remove it from the inventory
          if(carName == "Mercedes") {
            var newCarList = List(newSubList, inventory(i+1), inventory(i+2)) //give it new sublist, and return next untouched
            return newCarList
          }
          else if(carName == "Toyota") {
            var newCarList = List(inventory(i-1),newSubList,inventory(i+1)) //give it new sublist, and return next untouched
            return newCarList
          }
          else {
            var newCarList = List(inventory(i-2),inventory(i-1),newSubList) //give it new sublist, and return next untouched
            return newCarList
          }
        }
      }
    inventory
  }

  //give car to buyer
  def giveCar(carToGive: Car,buyer:Buyer) = {
    buyer.credits-=carToGive.carCost //subtract car cost from buyers budget
    buyer.carsBought ::= carToGive    // add the car to the buyer's bought cars
    println("You successfully purchased a " + carToGive.carName + "!")  //tell them they successfully purchased a car
    println("Credits left: " + (buyer.credits).toString())    //tell the buyer the amount of credits they have left
  }

  //removes something from list (really this creates a new list of cars... terrible
  def remove(car: Car, list: List[Car]) = list diff List(car)


  def changeXP(xpLevel: Int) = { //buyer enters their personally identified xp level, cannot be above 7
    val check = checkInt(50,101,"Enter your skill level on 1-10 scale", "Your skill is greater than 50 as a seller. Try again.")
    if (check < sellerXP) println("You cannot lose experience")
    else println("You have successfully gained experience!")
    sellerXP = check
  }

  def talk(greeting:String):String = {
    println("WE DON'T HAVE ANYTHING YOU WANT.") //this is different than parent class
    greeting
  }
  //when we print a buyer we want the following to print
  override def toString = "Name: "+sellerName+"\nAge: "+sellerAge+"\nEXP: "+sellerXP
}
