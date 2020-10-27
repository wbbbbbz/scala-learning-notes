object ClassDemo01 {

  def main(args: Array[String]): Unit = {

    val func1 = (a : Int) => "*" * a
    val list = (1 to 10).toList
//    println(list.map(func1(_)))
//    println(list.map(func1))
    println(list.map("*" * _))
  }



}
