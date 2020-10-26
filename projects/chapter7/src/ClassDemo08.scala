object ClassDemo08 {

  abstract class Person {
    def sayHello()
  }

  def show(person: Person) = person.sayHello()

  def main(args: Array[String]): Unit = {
    new Person {
      override def sayHello(): Unit = println("匿名内部类1 says hello")
    }.sayHello()

    show(new Person {
      override def sayHello(): Unit = println("匿名内部类2 says hello")
    })

  }
}
