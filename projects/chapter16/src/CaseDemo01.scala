import java.io.{BufferedWriter, FileWriter}

import scala.io.Source

object CaseDemo01 {

  def main(args: Array[String]): Unit = {
    val sc = Source.fromFile("data/1.txt")

    val list = sc.getLines().toList.distinct.map(_.toInt).sorted

    sc.close()

    val bw = new BufferedWriter(new FileWriter("data/2.txt"))

    bw.write(list.mkString("\r\n"))

    bw.close()
  }
}
