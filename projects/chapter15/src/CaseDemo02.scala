import java.io.File

object CaseDemo02 {

  def printFile(dir : File) : Unit = {
    if (dir.isFile) println(dir.toString)
    else if (dir.isDirectory) {
      dir.listFiles().foreach(printFile(_))
    }
  }

  def main(args: Array[String]): Unit = {
    printFile(new File("."))
  }
}
