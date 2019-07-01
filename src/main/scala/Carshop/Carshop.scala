package Carshop

import Drivingrange.DrivingRange
import Mainpack.validinputs._
import Mainpack.menu

import scala.util.Random._

object Carshop {

  //create starting inventory, a seller, and a buyer.
  //Note the order to creating cars must go Mercedes, Toyota, Buggy

  var inventory = Inventory(List(List(new Mercedes,new Mercedes,new Mercedes),List(new Toyota,new Toyota),List(new Buggy)))
  val buyer = new Buyer("Noah", 23, 5, 1500)
  val seller = new Seller("Noah", 23, 10, "98914626")

  def switch(x:Int):Boolean = {
    x match {
      case 1 =>
        //note that every time user decides to be a seller, the inventory will reset.
        inventory = Inventory(List(seller.makeCars(4,new Mercedes), seller.makeCars(3, new Toyota), seller.makeCars(2, new Buggy)))
        inventory.printCars(inventory.startingCars)
        true

      case 2 =>
        println("Default Inventory: ")
        inventory.printCars(inventory.startingCars)
        val carChoice = (checkInt(0,4,"Choose a car to buy (1 for mercedes, 2 for Toyota, 3 for Buggy): ", "Must be a mercedes(1), a toyota(2) or a Buggy(3)")-1)
        if(inventory.startingCars(carChoice) != Nil) {
          val choice = inventory.startingCars(carChoice).head.carName
          inventory = Inventory(seller.checkInventory(choice, inventory.startingCars, buyer)) //assign new inventory
          buyer.printBuyersCars(Nil)
        }
        else println("We don't have anymore of those cars. Sorry.")
        true

      case 3 =>
        println("Inventory: ")
        inventory.printCars(inventory.startingCars)

        val sellerOrBuyer = checkInt(0,3,"Are you a seller(1) or a buyer(2) ", "Invalid input, choose a titel.")
        if(sellerOrBuyer == 1) {
          val randCarList = List(new Mercedes, new Toyota, new Buggy)
          val sellersTrialCar = randCarList(nextInt(100) % 3)
          println("The car you get to drive at the ranch is a: "+sellersTrialCar+"\nNow going to the driving range.")
          //activate driving range protocol
          Drivingrange.DrivingRange         //TODO: IMPLEMENT AT A LATER TIME
          true //loop the program
        }
        else {
          println("Buyer, which car would you like to take out?")
          if(buyer.carsBought != Nil) {
            buyer.printBuyersCars(Nil)
            //activate driving range protocol
            Drivingrange.DrivingRange     //TODO: IMPLEMENT AT A LATER TIME
            true //loop the program
          }
          else {
            println("You have no currently available cars. In your list of cars. Going back to main menu")
            true //loop the program
          }
        }

      case 4 =>
        false
      case _ =>
        false//something terrible happened
    }
  }

  def loopCarshop(args:Array[String]): Boolean = {
    //get our user data information
    //val userDataList = getUserData TODO: ENABLE FOR FINAL PRODUCT
    //display our main menu
    def loop: Boolean={
      menu.carShopMenu
      //checks input, gives it to matchswitch, matchswitch does things, if returns false, program ended
      //else this functions is repeated
      if (switch(checkInt(0, 5, "Choose a menu option (1-3 or 4 to Quit): ","Invalid Input. Try again.")))
        loop
      else{println("Returning to the main menu.") //exit the program
        Mainpack.matcher.loopProgram(args) //go back and loop the previous menu
        false
      }
    }
    loop // tail recursive
  }
  def main(args: Array[String]) {
    loopCarshop(null)
    sys.exit(0) //to force an exit out of the Carshop when it exits for the main app

  }
}