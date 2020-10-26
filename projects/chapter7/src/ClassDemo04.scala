object ClassDemo04 {

  class Person {
    var name : String = _
    var age : Int = _
  }

  class Student extends Person {
    def sayHello() : Unit = println("Hello!")
  }

  def main(args: Array[String]): Unit = {
    //3. 通过多态的形式创建Student类型的对象.
    var test : Person = new Student()

    if (test.isInstanceOf[Student]){
      test.asInstanceOf[Student].sayHello()
    }
  }
}
