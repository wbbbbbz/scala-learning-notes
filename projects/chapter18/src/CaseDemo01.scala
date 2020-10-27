import scala.collection.mutable
import scala.io.StdIn

object CaseDemo01 {

  def main(args: Array[String]): Unit = {
    val input = StdIn.readLine().toCharArray

    val map = new mutable.HashMap[Char, Int]()

    for (i <- input){
      map.put(i, map.getOrElse(i, 0) + 1)
    }

    println(map.toString())


  }
}
