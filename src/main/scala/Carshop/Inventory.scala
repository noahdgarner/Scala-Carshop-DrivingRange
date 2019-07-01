package Carshop


//this is rhe MAIN REASON I had ttrouble, because this is declared as a case class
case class Inventory(var startingCars:List[List[Car]]) { //we want to create the guns and ammo at beginning of program,or if user chooses they are a seller


  def printCars(listToPrint:List[List[Car]]) ={
    for(i <- listToPrint) {
      for (j <- i){
        println(j.carName)
      }
    }
  }


  //TODO: ADD MORE TO THE CARSHOP INVENTORY



}
