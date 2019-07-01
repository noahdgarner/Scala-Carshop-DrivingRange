package Carshop

class Buyer(val buyerName:String,val buyerAge:Int,var buyerXP:Int,var credits: Int) extends Person(buyerName,buyerAge,buyerXP) { //these params must be named different than parent class
  println("Buyer created.")//tells us we successfully created a buyer
  var carsBought = List[Car]()


  def printBuyersCars(args: TraversableOnce[_]): Unit = {
    println("Here is a list of your recently purchased cars: ")
    if (args == Nil) carsBought.foreach(println); else args.foreach(println)
  }


  def changeXP(xpLevel: Int) = { //buyer enters their personally identified xp level, cannot be above 7
    if (xpLevel <= buyerXP)
      println("You must gain experience.")
    else if (buyerXP == 70)
      println("Level 70 is the max for a buyer.")
    else
      println("You have successfully gained experience!")
      buyerXP = xpLevel
  }

  def talk(greeting:String):String = {
    println("I AM A RICH BITCH.") //this is different than parent class
    greeting
  }
  //when we print a buyer we want the following to print
  override def toString = "Name: "+buyerName+"\nAge: "+buyerAge+"\nEXP: "+buyerXP
}
