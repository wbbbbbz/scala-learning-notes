object ClassDemo01 {

  def factorial(i : Int): Int = {
    if (i <= 1) 1 else (i * factorial(i - 1))
  }

  def main(args: Array[String]): Unit = {
    println(factorial(15))
  }
}
