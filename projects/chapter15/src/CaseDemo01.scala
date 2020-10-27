object CaseDemo01 {

  def fibb(i : Int) : Int = {
    if (i <= 2) 1 else (fibb(i - 2) + fibb(i - 1))
  }

  def main(args: Array[String]): Unit = {
//    println(fibb(12))

    var last = 1
    var curr = 1
    for(i <- (3 to 12)){
      var temp = curr
      curr += last
      last = temp
    }
    println(curr)
  }

}
