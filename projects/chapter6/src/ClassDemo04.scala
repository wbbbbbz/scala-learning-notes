object ClassDemo04 {

  //1. 定义一个Person类, 属性为: name
  class Person(private[this] var name: String)

  //2. 定义Person类的伴生对象.
  object Person {
    //3. 定义一个方法printPerson, 用来打印Person#name属性值.
    //此处p.name报错。无法访问
//    def printPerson(p:Person) = println(p.name)
  }

  //定义main函数, 它是程序的主入口
  def main(args: Array[String]) = {
    //4. 创建Person类型的对象.
    val p = new Person("张三")
    //5. 调用Person伴生对象中的printPerson方法
//    Person.printPerson(p)
  }
}
