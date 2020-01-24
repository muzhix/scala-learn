import java.io.File
import java.util
import java.util.{Calendar, Scanner}

import scala.jdk.CollectionConverters._
import scala.collection.{SortedMap, mutable}

object charpter04 {

  /** 1 */
  def question1(): Map[String, Double] = {
    val items = Map("apple" -> 20, "pear" -> 30, "banana" -> 15)
    for ((item, price) <- items)
      yield (item, price * 0.9)
  }

  /** 2 */
  def question2(filepath: String): mutable.Map[String, Int] = {
    val in = new Scanner(new File(filepath))
    val words = mutable.Map[String, Int]()
    while (in.hasNext) {
      val key: String = in.next()
      words(key) = words.getOrElse(key, 0) + 1
    }
    words
  }

  /** 3 */
  def question3(filepath: String): Map[String, Int] = {
    val in = new Scanner(new File(filepath))
    var words = Map[String, Int]()
    while (in.hasNext) {
      val key: String = in.next()
      words += (key -> (words.getOrElse(key, 0) + 1))
    }
    words
  }

  /** 4 */
  def question4(filepath: String): SortedMap[String, Int] = {
    val in = new Scanner(new File(filepath))
    var words = mutable.SortedMap[String, Int]()
    while (in.hasNext) {
      val key: String = in.next()
      words(key) = words.getOrElse(key, 0) + 1
    }
    words
  }

  /** 5 */
  def question5(filepath: String): mutable.Map[String, Int] = {
    var res = new util.TreeMap[String, Int].asScala

    val in = new Scanner(new File(filepath))
    val words = mutable.Map[String, Int]()
    while (in.hasNext) {
      val key: String = in.next()
      words(key) = words.getOrElse(key, 0) + 1
    }
    words
  }

  /** 6 */
  def question6(): Map[String, Int] = {
    var map = mutable.LinkedHashMap[String, Int]()
    classOf[java.util.Calendar].getFields.foreach(x => map += (x.getName -> x.getInt(null)))
    map.toMap
  }

  def question7(): Unit = {
    val props = System.getProperties.asScala
    val maxLen = props.map(p => p._1.length).max

    props.foreach(p => println(p._1 + " " * (maxLen - p._1.length + 1) + "|" + p._2))
  }

  /** 8 */
  def question8(arr: Array[Int]): (Int, Int) = {
    (arr.min, arr.max)
  }

  /** 9 */
  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
    (values.count(_ < v), values.count(_ == v), values.count(_ > v))
  }

  def main(args: Array[String]): Unit = {
    //    var scores = SortedMap("bob" -> 2, "alice" -> 4)
    //    val newScores = scores + ("bob" -> 3, "fred" -> 5)
    //
    //    println(scores.mkString(" | "))
    //    println(newScores.mkString(" | "))
    //    println(question1().mkString(" | "))
    //    question2("static/words.txt").foreach(println)
    //    println(question2("static/words.txt").mkString(" | "))
    //    println(question3("static/words.txt").mkString(" | "))
    //    println(question4("static/words.txt").mkString(" | "))
    //    println(question6().mkString("\n"))
    //    question7()
    //    println(question8(Array(1, -2, 3, -4, 4, -5, 5, -8, -9, -10, 11)))
    //    println(lteqgt(Array(1, -2, 3, -4, 4, -5, 5, -8, -9, -10, 11), 0))
    println("hello".zip("world"))
  }

}
