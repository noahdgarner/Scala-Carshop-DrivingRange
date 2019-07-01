package Mainpack
import org.apache.spark.{SparkConf, SparkContext}
import validinputs._

object sparkfilereader {

  val conf = new SparkConf()
  conf.setMaster("local")
  conf.setAppName("Vowel Count")
  val sc = new SparkContext(conf)

  def fileVowels(b:Boolean): List[Int] = {
    //set up our thing
    if(b) {
      val userFilePath = checkString(0,100,"Please enter the absolute path of your file: ","Invalid path. Try again.")
      val wordsFile = sc.textFile(userFilePath)

      val flattenMap = wordsFile.flatMap(line => line.toLowerCase.replaceAll("[^aeiou]", " ").split(" ")).filter(_ != "").map((_, 1)).reduceByKey(_ + _)
      val vNList = flattenMap.collect().toList //cintains list (string,string) vN vowel Num list
      val splicedList = for (i <- (0 until vNList.length).toList; if (vNList(i)._1 == "a" || vNList(i)._1 == "e" ||
        vNList(i)._1 == "i" || vNList(i)._1 == "o" || vNList(i)._1 == "u")) yield vNList(i)
      splicedList.sortWith(_._1 < _._1).foreach(println) //RRD's are out of order
      //this will print to console to show we have correct data
      val iVT = splicedList.sortWith(_._1 < _._1).map(_._2) //iVT = individualVowelTotals
      List(iVT(0),iVT(1),iVT(2),iVT(3),iVT(4),iVT(0)+iVT(1)+iVT(2)+iVT(3)+iVT(4))
    }

    else {
      val wordsFile = sc.textFile("src/main/Resources/shakespeare.txt")
      val flattenMap = wordsFile.flatMap(line => line.toLowerCase.replaceAll("[^aeiou]", " ").split(" ")).filter(_ != "").map((_, 1)).reduceByKey(_ + _)
      val vNList = flattenMap.collect().toList //contains list (string,string) vN vowel Num list
      val splicedList = for (i <- 0 until vNList.length - 1; if (vNList(i)._1 == "a" || vNList(i)._1 == "e" ||
        vNList(i)._1 == "i" || vNList(i)._1 == "o" || vNList(i)._1 == "u")) yield vNList(i)
      splicedList.sortWith(_._1 < _._1).foreach(println) //RRD's are out of order
      //this will print to console to show we have correct data
      val iVT = splicedList.sortWith(_._1 < _._1).map(_._2) //iVT = individualVowelTotals
      List(iVT(0),iVT(1),iVT(2),iVT(3),iVT(4),iVT(0)+iVT(1)+iVT(2)+iVT(3)+iVT(4))
    }
  }

}
