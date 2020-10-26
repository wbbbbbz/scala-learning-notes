//案例: 演示Scala中的apply方法
object ClassDemo05 {
  //1. 定义Person类, 属性为姓名和年龄
  class Person(var name: String = "", var age: Int = 0)

  //2. 定义Person类的伴生对象.
  object Person {
    //3. 定义apply方法, 实现创建Person对象的时候免new.
    def apply(name:String, age:Int) = new Person(name, age)
  }

  //定义main方法, 作为程序的主入口
  def main(args: Array[String]): Unit = {
    //4. 创建Person类型的对象.
    val p = Person("张三", 23)
    //5. 打印Person对象的属性值.
    println(p.name, p.age)
  }
}
