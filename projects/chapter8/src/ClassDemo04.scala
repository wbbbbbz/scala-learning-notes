object ClassDemo04 {

  //1. 定义一个特质Hero
  trait Hero{
    var name = ""     //具体字段
    var arms:String   //抽象字段

    //具体方法
    def eat() = println("吃肉喝酒, 养精蓄锐!")

    //抽象方法
    def toWar():Unit
  }

  //2. 定义一个类Generals, 继承Hero特质, 重写其中所有的抽象成员.
  class Generals extends Hero {
    //重写父特质中的抽象字段
    override var arms: String = ""

    //重写父特质中的抽象方法
    override def toWar(): Unit = println(s"${name}带着${arms}, 上阵杀敌!")
  }

  //main方法, 作为程序的入口
  def main(args: Array[String]): Unit = {
    //3. 创建Generals类的对象.
    val gy = new Generals

    //4. 测试Generals类中的内容.
    //给成员变量赋值
    gy.name = "关羽"
    gy.arms = "青龙偃月刀"
    //打印成员变量值
    println(gy.name, gy.arms)
    //调用成员方法
    gy.eat()
    gy.toWar()
  }
}
