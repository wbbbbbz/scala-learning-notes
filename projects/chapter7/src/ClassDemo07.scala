object ClassDemo07 {

  abstract class Person {
    var occupation : String
  }

  class Student extends Person{
    override var occupation: String = "学生"
  }

  class Teacher extends Person{
    override var occupation: String = "老师"
  }

  //main方法, 作为程序的主入口
  def main(args: Array[String]): Unit = {
    //4. 创建Student类的对象, 打印occupation的值.
    val s = new Student
    println(s.occupation)
    //5. 创建Teacher类的对象, 打印occupation的值.
    val t = new Teacher
    println(t.occupation)
  }
}
