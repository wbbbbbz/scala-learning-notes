//案例: 演示模板方法设计模式
object ClassDemo07 {

  //1. 定义一个模板类Template, 添加code()和getRuntime()方法, 用来获取某些代码的执行时间.
  abstract class Template {
    //定义code()方法, 用来记录所有要执行的代码
    def code()

    //定义模板方法, 用来获取某些代码的执行时间.
    def getRuntime() = {
      //获取当前时间毫秒值
      val start = System.currentTimeMillis()
      //具体要执行的代码
      code()
      //获取当前时间毫秒值
      val end = System.currentTimeMillis()
      //返回指定代码的执行时间.
      end - start
    }
  }

  //2. 定义类ForDemo继承Template, 然后重写getRuntime()方法, 用来计算打印10000次"Hello,Scala!"的执行时间.
  class ForDemo extends Template {
    override def code(): Unit = for(i <- 1 to 10000) println("Hello, Scala!")
  }

  def main(args: Array[String]): Unit = {
    //3. 测试打印10000次"Hello, Scala!"的执行时间
    println(new ForDemo().getRuntime())
  }
}