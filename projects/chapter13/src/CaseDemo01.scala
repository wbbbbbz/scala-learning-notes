object CaseDemo01 {

  def main(args: Array[String]): Unit = {

    def calc(i1: Int, i2: Int)(f: (Int, Int) => Int) = f(i1, i2)

    println(calc(3, 5)(_ + _))
    println(calc(3, 5)(_ - _))
    println(calc(3, 5)(_ * _))
    println(calc(3, 5)(_ / _))
  }
}
