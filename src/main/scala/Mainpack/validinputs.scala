package Mainpack

import scala.util._

object validinputs {
  //checks integer input recursively
  def checkInt(lower: Int, upper: Int, prompt: String, errorMsg: String): Int = {
    def rep(lower: Int, upper: Int, prompt: String): Int = {
      print(prompt)
      val x = scala.io.StdIn.readLine()
      if (Try(x.toInt).isSuccess && x.toInt > lower && x.toInt < upper) x.toInt
      else {
        println(errorMsg)
        rep(lower, upper, prompt)
      }
    }
    rep(lower,upper,prompt)
  }
  //checks string input
  def checkString(lower: Int, upper: Int, prompt: String, errorMsg: String): String = {
    def rep(lower: Int, upper: Int, prompt: String): String = {
      print(prompt)
      val x = scala.io.StdIn.readLine()
      if (x.length > lower && x.length < upper) x
      else {
        println(errorMsg)
        rep(lower, upper, prompt)
      }
    }
    rep(lower,upper,prompt) //tail recursive
  }
  //check if yes, no, quit, or back
  def checkYesNo(prompt: String): Boolean = {
    def rep(prompt: String): Boolean = {
      print(prompt)
      val x = scala.io.StdIn.readLine()
      if (x == "Q" || x == "quit" || x == "q" || x == "Quit" || x == "n" ||  x == "no" || x == "N" || x == "No") false
      else if (x == "b" || x  == "B" || x == "Back" || x == "back" || x == "y" || x == "yes" || x == "Y" || x == "Yes") true
      else {
        println("That input is invalid");rep(prompt)
      }
    }
    rep(prompt) //tail recursive
  }


  //def fileReader(aFile: File): (String, Int)
  //tuple of user data, just strings and integers, maybe be used later? hopefully we can send this to the spark and do cool things with it later
  def getUserData: (String,String,Int,String,String) = (
    checkString(3, 33, "Enter first name (4-32 chars): ","Invalid Input. Try again."), //get user first name
    checkString(3, 33, "Enter last name(4-32 chars): ","Invalid Input. Try again."), //get user last name
    checkInt(3, 80, "Enter age (3-80 chars): ","Invalid Input. Try again."), //get user age
    checkString(3, 41, "Enter street address(4-50 chars): ","Invalid Input. Try again."), //get user street address
    checkString(9, 11, "Enter phone number(10 chars): ","Invalid Input. Try again.") //get user [hone number
  )

}
