package Mainpack

object menu {
  //main menu
  def mainMenu {
    println("WELCOME TO MY SUPER DUMB MULTI FUNCTIONAL SCALA PROGRAM (DevELOP By noAH gARnER1!!!111!)")
    println("|======================================================================================|")
    println("1. Reverse a String – Enter a string and the program will reverse, and print it.")
    println("2. Pig Latin - This will take a word like Dicks, and convert it to icks-day.")
    println("3. Check if a string is a palindrome.")
    println("4. Count Vowels - counts the vowels in a string or text file, and sums them. (spark?)")
    println("---------------------------------------------------------------------------------------")
    println("5. Enter the car shop. Customize your car, and drive your car on a range.")
    println("6. Activated Class Application Scala Swing app (Application terminates when window closes.")
    println("7. Quit.")
  }

  def carShopMenu: Unit = {
    println("WELCOME TO THE CAR SHOP (DevELOP By noAH gARnER1!!!111!)")
    println("|======================================================|")
    println("1. Be a seller")
    println("2. Be a buyer.")
    println("3. Go to the Driving Range (You need to have bought some cars, or if you're a seller, you get a random car from the inventory).")
    println("4. Leave the store.")
  }

  def drivingRangeMenu: Unit = {
    println("WELCOME TO THE DRIVING RANGE (DevELOP By noAH gARnER1!!)")
    println("|======================================================|")
    println("1. Drive your car")
    println("2. Get some gas.")
    println("3. Fix your car (durability is 0)")
    println("4. Leave the driving range.")
  }

}
