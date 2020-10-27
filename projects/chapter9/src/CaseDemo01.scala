object CaseDemo01 {

  case class Calculate() {

    def plus(i : Int, j : Int) =  (i + j)
    def minus(i : Int, j : Int) =  (i - j)
    def times(i : Int, j : Int) =  (i * j)
    def divide(i : Int, j : Int) =  (i / j)

  }

  def main(args: Array[String]): Unit = {
    println(Calculate().plus(3, 5))
    println(Calculate().minus(10, 5))
    println(Calculate().times(3, 5))
    println(Calculate().divide(512, 5))
  }
}
