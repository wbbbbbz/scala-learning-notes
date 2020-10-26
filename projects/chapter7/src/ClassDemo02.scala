object ClassDemo02 {

  class Person {
    var name : String = _

    def sayHello() : Unit = println(s"${this.name} says Hello!")
  }

  object Student extends Person

  def main(args : Array[String]) : Unit = {
    //3. 测试Student中的成员.
    Student.name = "张三"
    println(Student.name)
    Student.sayHello()
  }
}
