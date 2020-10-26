object ClassDemo01 {

  class Person {

    var name : String = _
    var age : Int = _

    def eat() : Unit = println(s"${this.age}岁的${this.name}正在吃饭")

  }
  class Student extends Person

  class Teacher extends Person

  def main(args: Array[String]): Unit = {
    //4. 测试老师类.
    val t = new Teacher
    t.name = "刘老师"
    t.age = 32
    println(t.name, t.age)
    t.eat()
    println("-" * 15)
    //5. 测试学生类.
    val s = new Student
    s.name = "张三"
    s.age = 23
    println(s.name, s.age)
    s.eat()
  }
}
