object ClassDemo03 {

  //1. 定义父类Person.
  class Person {
    var name = "张三"
    val age = 23

    def sayHello() = println("Hello, Person!...")
  }
  //2. 定义子类Student, 继承Person.
  class Student extends Person{
  //  override var name = "李四"    //这样写会报错, 子类不能重写父类用var修饰的变量.
    override val age = 24

    override def sayHello() = {
      //通过super调用父类的成员.
      super.sayHello()
      println("Hello, Student!...")
    }
  }
  //程序的入口.
  def main(args: Array[String]): Unit = {
    //3. 创建学生类型的对象, 然后测试.
    val s = new Student
    println(s.name, s.age)
    s.sayHello()
  }
}
