package Mainpack
import validinputs._
import sparkfilereader.fileVowels
object stringfuncs {

  //reverse it tail recursively
  def reverseString: String = {
    val s = checkString(0,101,"Enter a string to reverse with length 0-100: ","Invalid Input. Length 0-100.")
    def rev(s: String, r: String): String = {
      if (s == null) return null
      if ((s tail) isEmpty) return (s head) + r
      rev(s tail, (s head) + r)
    }
    rev(s, "") //tail recursive, notice it creates a base case
  }
  //we will use slice here
  def pigLatinize: String = {
    val s = checkString(1,41,"Enter a string to pigify (preferably 1 word): ","Invalid Input. Length 0-40")
    s.slice(1,s.length)+"-"+s.slice(0,1)+"ay"
  }
  //check palindrome
  def isPalindrome: Boolean = {
    val s = checkString(1,201,"Enter a string of anything to see if it has a palindrome (reads same forwards as backwards): ","Invalid input, length 0-200")
    for(i <- 0 until s.length/2){
      if(s(i) != s(s.length-i-1)) {
        return false //these are required for some reason?
      }
    }
    return true // these are required for some reason?
  }
  //count vowels, uses sparkfilereader if the user chooses to read vowels in a file
  def countVowels: List[Int] = {
    val m = checkInt(0, 3, "Do you want to count vowels in a string(1), or a file(2)? (Enter 1 or 2): ","Invalid Input. Enter 1 or 2.")
    m match {
      //reverse string case
      case 1 => {
        val checkme = checkString(0, 501,
          "Enter a string to check for vowels (not counting 'y'),\n" +
                   "and I will print all vowels in it, and the sum. (1-500): ","Invalid Input. Enter 1 or 2.")
        stringVowels(checkme)
      }
      case 2 => {
        if (checkYesNo("Do you want to check a file on your system? (Enter Y, y, or N, n): ")) {
          "Checking file on your system." //implement, hitting no so we can implement shakespeare.txt
          fileVowels(true)
        }
        else {
          "Checking Shakespeare.txt in resources foulder." // implement, default if user says no
          fileVowels(false)
        }
      }
      case _ =>
        "Something went terribly wrong."
        null
    }
  }
  //called if the user wants to input their own string
  def stringVowels(s: String): List[Int] = {
    val aCnt = (s.length - s.replaceAll("[a]", "").length)
    val eCnt = (s.length - s.replaceAll("[e]", "").length)
    val iCnt = (s.length - s.replaceAll("[i]", "").length)
    val oCnt = (s.length - s.replaceAll("[o]", "").length)
    val uCnt = (s.length - s.replaceAll("[u]", "").length)
    println("hello")
    List(aCnt,eCnt,iCnt,oCnt,uCnt,aCnt+eCnt+iCnt+oCnt+uCnt)
  }

}
