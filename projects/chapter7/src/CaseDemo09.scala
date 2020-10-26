object CaseDemo09 {

  abstract class Animal {
    var name : String
    var age : Int

    def run() :Unit = println(s"${age}岁的${name}在跑步")

    def eat() :Unit = println(s"${age}岁的${name}在吃饭")
  }

  class Cat extends Animal{
    override var name: String = "猫"
    override var age: Int = 2
    def catchMouse() : Unit = println("猫抓老鼠")
  }

  class Dog extends Animal{
    override var name: String = "狗"
    override var age: Int = 3
    def watch() : Unit = println("狗看家")
  }

  //main方法, 作为程序的入口
  def main(args: Array[String]): Unit = {
    //4. 测试猫类.
    //4.1 创建猫类对象.
    val c = new Cat
    //4.2 给成员变量赋值.
    c.name = "汤姆"
    c.age = 13
    //4.3 打印成员变量值
    println(c.name, c.age)
    //4.4 调用方法.
    c.eat()
    //4.5 调用猫类的独有功能: 抓老鼠
    if (c.isInstanceOf[Cat]) {
      val cat = c.asInstanceOf[Cat]
      cat.catchMouse()
    } else if(c.isInstanceOf[Dog]) {
      val dog = c.asInstanceOf[Dog]
      dog.watch()
    } else{
      println("您传入的不是猫类, 也不是狗类对象")
    }

    //5. 测试狗类
    //5.1 创建猫类对象.
    val d = new Dog
    //5.2 给成员变量赋值.
    d.name = "狗"
    d.age = 5
    //5.3 打印成员变量值
    println(d.name, d.age)
    //5.4 调用方法.
    d.eat()
    //5.5 调用狗类的独有功能: 看家
    if (d.isInstanceOf[Dog]) {
      d.asInstanceOf[Dog].watch()
    } else if(d.isInstanceOf[Cat]) {
      d.asInstanceOf[Cat].catchMouse()
    } else{
      println("您传入的不是猫类, 也不是狗类对象")
    }
  }
}
