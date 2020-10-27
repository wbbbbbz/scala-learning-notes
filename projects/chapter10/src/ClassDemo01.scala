import scala.collection.mutable.ArrayBuffer

object ClassDemo01 {

  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer(4,1,6,5,2,3)
    println(arr.sum)
    println(arr.max)
    println(arr.min)
    println(arr.sorted)
    println(arr.reverse)
    println(arr += 41)
  }
}
