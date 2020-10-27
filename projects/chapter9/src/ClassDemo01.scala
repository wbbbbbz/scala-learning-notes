object ClassDemo01 {

  case class Person(val name : String, var age : Int)

  def main(args: Array[String]): Unit = {

    var person = new Person("aaa", 5)
    println(person.name, person.age)
    // 报错
    //    person.name = "sg"
    person.age = 7
  }
}
