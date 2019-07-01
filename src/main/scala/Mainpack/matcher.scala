package Mainpack
import Carshop._
import validinputs._
import stringfuncs._
import Carshop._

object matcher {
  //switch/match statement that will call our various programs
  //the beef of our program
  def matchSwitch(x: Int): Boolean = x match {
    //reverse string case
    case 1 =>
      println("Your reversed string is: "+reverseString)
      checkYesNo("\nWould you like to Quit? (Enter q or Q)\nBack to the main menu? (Enter b or B)\nDecision: ")

    //call piggy function, and ask to continue
    case 2 =>
      println("Your pigified string is: "+pigLatinize)
      checkYesNo("\nWould you like to Quit? (Enter q or Q)\nBack to the main menu? (Enter b or B)\nDecision: ")

    // check if string is a palindrome
    case 3 =>
      if(isPalindrome)
        println("Your string is a palindrome!")
      else
        println("Your string is NOT a palindrome, sorry.")
      checkYesNo("\nWould you like to Quit? (Enter q or Q)\nBack to the main menu? (Enter b or B)\nDecision: ")

    //Count Vowels - counts the vowels in a string or text file, and sums them
    case 4 =>
      val list = countVowels //its not that parallel, you must set this val to a val to print list
      println("#a's: "+list(0)+"\n#e's: "+list(1)+"\n#i's: "+list(2)
        +"\n#o's: "+list(3)+"\n#u's: "+list(4)+"\nTotal Vowels: "+list(5))
      checkYesNo("\nWould you like to Quit? (Enter q or Q)\nBack to the main menu? (Enter b or B)\nDecision: ")

    //bring user to sort and search menu
    case 5 =>
      println("Activated Class Application GunStore")
      Carshop.main(null) //activate gunstore
      checkYesNo("\nWould you like to Quit? (Enter q or Q)\nBack to the main menu? (Enter b or B)\nDecision: ")

    case 6 =>
      println("NOT IMPLEMENTED YET.")
      checkYesNo("\nWould you like to Quit? (Enter q or Q)\nBack to the main menu? (Enter b or B)\nDecision: ")

    case 7 =>
      false

    case _ =>
      false //in case something goes horribly wrong
  }
  //loops our program
  def loopProgram(args:Array[String]): Boolean = {
    //get our user data information
    //val userDataList = getUserData TODO: ENABLE WHEN FINAL PRODUCT
    //display our main menu
    def loop: Boolean={
      menu.mainMenu
      //checks input, gives it to matchswitch, matchswitch does things, if returns false, program ended
      //else this functions is repeated
      if (matchSwitch(checkInt(0, 8, "Choose a menu option (1-6 or 7 to Quit): ","Invalid Input. Try again.")))
        loop
      else println("Exiting the program. Have a nice day.") //exit the program
        false
    }
    loop // tail recursive
  }
}
