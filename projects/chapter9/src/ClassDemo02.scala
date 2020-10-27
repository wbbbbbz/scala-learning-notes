object ClassDemo02 {

  trait Sex

  case object Male extends Sex

  case object Female extends Sex

  case class Person(name:String, sex: Sex){}

  def main(args: Array[String]): Unit = {
    var person = new Person("aaa", sex = Male)
    println(person)
  }
}
