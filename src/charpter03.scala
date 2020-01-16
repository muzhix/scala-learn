import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object charpter03 {

  /** 1 */
  def question1(n: Int): Array[Int] = {
    (for (i <- 1 to n) yield Random.nextInt(n)).toArray
  }

  /** 2 */
  def question2(arr: Array[Int]): Array[Int] = {
    val l = arr.length
    for (i <- 0 until (if (l % 2 == 0) l else l - 1) by 2) {
      val tmp = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = tmp
    }
    arr
  }

  /** 3 */
  def question3(arr: Array[Int]): Array[Int] = {
    val newArr = for (i <- arr.indices) yield {
      if (i % 2 == 0)
        if (i + 1 < arr.length) arr(i + 1) else arr(i)
      else
        arr(i - 1)
    }
    newArr.toArray
  }

  /** 4 */
  def question4(arr: Array[Int]): Array[Int] = {
    arr.filter(_ > 0) ++ arr.filter(_ <= 0)
  }

  /** 5 */
  def question5(arr: Array[Double]): Double = {
    var arrSum: BigDecimal = 0
    arr.foreach(arrSum += _)
    (arrSum / arr.length).toDouble
  }

  /** 6 */
  def question6(arr: Array[Int]): Array[Int] = {
    arr.reverse
  }

  /** 7 */
  def question7(arr: Array[AnyRef]): Array[AnyRef] = {
    arr.distinct
  }

  /** 8 */
  def question8(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val negativePos = for (i <- arr.indices if arr(i) < 0) yield i
    negativePos.reverse.init.foreach(arr.remove)
    arr
  }

  /** 9 */
  def question9(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var negNum = 0;
    var posPair = ArrayBuffer[(Int, Int)]()
    for (i <- arr.indices) {
      if (arr(i) > 0 && negNum > 1)
        posPair.append((i, i - negNum + 1))
      if (arr(i) < 0) negNum += 1
    }

    for ((from, to) <- posPair) {
      arr(to) = arr(from)
    }
    arr.trimEnd(negNum - 1)
    arr
  }

  /** 10 */
  def question10(): Array[String] = {
    java.util.TimeZone.getAvailableIDs().filter(_.startsWith("America")).map(_.drop(8)).sorted
  }

  /** 11 */
  def question11(): mutable.Buffer[AnyRef] = {
    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    flavors.getNativesForFlavor(DataFlavor.imageFlavor).toArray.toBuffer
  }

  def main(args: Array[String]): Unit = {
    //    println(question2(Array(1, 2, 3, 4)).mkString)
    //    println(question3(Array(1, 2, 3, 4)).mkString)
    //    println(question4(Array(1, -2, 3, -4, 4)).mkString)
    //    println(question5(Array(Double.MaxValue - 100, Double.MaxValue - 1000)))
    //    println(question8(ArrayBuffer(1, -2, 3, -4, 4, -5, 5)).mkString(" | "))
    //    println(question9(ArrayBuffer(1, -2, 3, -4, 4, -5, 5, -8, -9, -10, 11)).mkString(" | "))
    //    question10() foreach println
    question11() foreach println
  }
}
